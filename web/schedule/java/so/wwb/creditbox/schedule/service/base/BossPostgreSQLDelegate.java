package so.wwb.creditbox.schedule.service.base;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.jdbcjobstore.PostgreSQLDelegate;
import org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate;
import org.quartz.impl.jdbcjobstore.TriggerStatus;
import org.quartz.impl.jdbcjobstore.Util;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.OperableTrigger;
import so.wwb.creditbox.schedule.service.utility.ServiceManager;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.*;

import static org.quartz.JobKey.jobKey;
import static org.quartz.TriggerBuilder.newTrigger;

public class BossPostgreSQLDelegate extends PostgreSQLDelegate {

    String SELECT_MISFIRED_TRIGGERS = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2})"
            + " AND NOT ("
            + COL_MISFIRE_INSTRUCTION + " = " + Trigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY + ") AND "
            + COL_NEXT_FIRE_TIME + " < ? "
            + " ORDER BY " + COL_NEXT_FIRE_TIME + " ASC, " + COL_PRIORITY + " DESC";

    String SELECT_TRIGGERS_IN_STATE = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST + " AND "
            + COL_TRIGGER_STATE + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_MISFIRED_TRIGGERS_IN_STATE = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST + " AND NOT ("
            + COL_MISFIRE_INSTRUCTION + " = " + Trigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY + ") AND "
            + COL_NEXT_FIRE_TIME + " < ? AND " + COL_TRIGGER_STATE + " = ? "
            + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) "
            + " ORDER BY " + COL_NEXT_FIRE_TIME + " ASC, " + COL_PRIORITY + " DESC";

    String COUNT_MISFIRED_TRIGGERS_IN_STATE = "SELECT COUNT("
            + COL_TRIGGER_NAME + ") FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST + " AND NOT ("
            + COL_MISFIRE_INSTRUCTION + " = " + Trigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY + ") AND "
            + COL_NEXT_FIRE_TIME + " < ? "
            + " AND " + COL_TRIGGER_STATE + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_HAS_MISFIRED_TRIGGERS_IN_STATE = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST + " AND NOT ("
            + COL_MISFIRE_INSTRUCTION + " = " + Trigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY + ") AND "
            + COL_NEXT_FIRE_TIME + " < ? "
            + " AND " + COL_TRIGGER_STATE + " = ? "
            + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) "
            + " ORDER BY " + COL_NEXT_FIRE_TIME + " ASC, " + COL_PRIORITY + " DESC";

    String SELECT_MISFIRED_TRIGGERS_IN_GROUP_IN_STATE = "SELECT "
            + COL_TRIGGER_NAME
            + " FROM "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST + " AND NOT ("
            + COL_MISFIRE_INSTRUCTION + " = " + Trigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY + ") AND "
            + COL_NEXT_FIRE_TIME
            + " < ? AND "
            + COL_TRIGGER_GROUP
            + " = ? AND " + COL_TRIGGER_STATE + " = ? "
            + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) "
            + " ORDER BY " + COL_NEXT_FIRE_TIME + " ASC, " + COL_PRIORITY + " DESC";

    String SELECT_TRIGGERS_FOR_JOB = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME
            + " = ? AND " + COL_JOB_GROUP + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_TRIGGERS_FOR_CALENDAR = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_CALENDAR_NAME
            + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_TRIGGER_EXISTENCE = "SELECT "
            + COL_TRIGGER_NAME + " FROM " + TABLE_PREFIX_SUBST + TABLE_TRIGGERS
            + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP
            + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_NUM_TRIGGERS_FOR_JOB = "SELECT COUNT("
            + COL_TRIGGER_NAME + ") FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME + " = ? AND "
            + COL_JOB_GROUP + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_JOB_FOR_TRIGGER = "SELECT J."
            + COL_JOB_NAME + ", J." + COL_JOB_GROUP + ", J." + COL_IS_DURABLE
            + ", J." + COL_JOB_CLASS + ", J." + COL_REQUESTS_RECOVERY + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " T, " + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS
            + " J WHERE T." + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND J." + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND T." + COL_TRIGGER_NAME + " = ? AND T."
            + COL_TRIGGER_GROUP + " = ? AND T." + COL_JOB_NAME + " = J."
            + COL_JOB_NAME + " AND T." + COL_JOB_GROUP + " = J."
            + COL_JOB_GROUP + " AND T." + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_TRIGGER = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_TRIGGER_DATA = "SELECT " +
            COL_JOB_DATAMAP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_TRIGGER_STATE = "SELECT "
            + COL_TRIGGER_STATE + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND "
            + COL_TRIGGER_GROUP + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_TRIGGER_STATUS = "SELECT "
            + COL_TRIGGER_STATE + ", " + COL_NEXT_FIRE_TIME + ", "
            + COL_JOB_NAME + ", " + COL_JOB_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_BLOB_TRIGGER = "SELECT *" + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_BLOB_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String SELECT_NUM_TRIGGERS = "SELECT COUNT("
            + COL_TRIGGER_NAME + ") " + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_NUM_TRIGGERS_IN_GROUP = "SELECT COUNT("
            + COL_TRIGGER_NAME + ") " + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_GROUP + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_TRIGGER_GROUPS = "SELECT DISTINCT("
            + COL_TRIGGER_GROUP + ") FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_TRIGGER_GROUPS_FILTERED = "SELECT DISTINCT("
            + COL_TRIGGER_GROUP + ") FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST + " AND " + COL_TRIGGER_GROUP + " LIKE ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_TRIGGERS_IN_GROUP_LIKE = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM " + TABLE_PREFIX_SUBST + TABLE_TRIGGERS
            + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_GROUP + " LIKE ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_TRIGGERS_IN_GROUP = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM " + TABLE_PREFIX_SUBST + TABLE_TRIGGERS
            + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_GROUP + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_REFERENCED_CALENDAR = "SELECT "
            + COL_CALENDAR_NAME + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_CALENDAR_NAME + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_NEXT_FIRE_TIME = "SELECT MIN("
            + COL_NEXT_FIRE_TIME + ") AS " + ALIAS_COL_NEXT_FIRE_TIME
            + " FROM " + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_STATE + " = ? AND " + COL_NEXT_FIRE_TIME + " >= 0" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_TRIGGER_FOR_FIRE_TIME = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_STATE + " = ? AND " + COL_NEXT_FIRE_TIME + " = ?" + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) ";

    String SELECT_NEXT_TRIGGER_TO_ACQUIRE = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + ", "
            + COL_NEXT_FIRE_TIME + ", " + COL_PRIORITY + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_STATE + " = ? AND " + COL_NEXT_FIRE_TIME + " <= ? "
            + " AND (" + COL_MISFIRE_INSTRUCTION + " = -1 OR (" + COL_MISFIRE_INSTRUCTION + " != -1 AND " + COL_NEXT_FIRE_TIME + " >= ?)) "
            + " AND " + COL_JOB_NAME + " in(select job_code from task_schedule where belong_to_idc={2}) "
            + " ORDER BY " + COL_NEXT_FIRE_TIME + " ASC, " + COL_PRIORITY + " DESC";

    public BossPostgreSQLDelegate() {
        /*SELECT_MISFIRED_TRIGGERS=rtpp(SELECT_MISFIRED_TRIGGERS);
        SELECT_TRIGGERS_IN_STATE=rtpp(SELECT_TRIGGERS_IN_STATE);
        SELECT_MISFIRED_TRIGGERS_IN_STATE=rtpp(SELECT_MISFIRED_TRIGGERS_IN_STATE);
        COUNT_MISFIRED_TRIGGERS_IN_STATE=rtpp(COUNT_MISFIRED_TRIGGERS_IN_STATE);
        SELECT_HAS_MISFIRED_TRIGGERS_IN_STATE=rtpp(SELECT_HAS_MISFIRED_TRIGGERS_IN_STATE);
        SELECT_MISFIRED_TRIGGERS_IN_GROUP_IN_STATE=rtpp(SELECT_MISFIRED_TRIGGERS_IN_GROUP_IN_STATE);
        SELECT_TRIGGERS_FOR_JOB=rtpp(SELECT_TRIGGERS_FOR_JOB);
        SELECT_TRIGGERS_FOR_CALENDAR=rtpp(SELECT_TRIGGERS_FOR_CALENDAR);
        SELECT_TRIGGER_EXISTENCE=rtpp(SELECT_TRIGGER_EXISTENCE);
        SELECT_NUM_TRIGGERS_FOR_JOB=rtpp(SELECT_NUM_TRIGGERS_FOR_JOB);
        SELECT_JOB_FOR_TRIGGER=rtpp(SELECT_JOB_FOR_TRIGGER);
        SELECT_TRIGGER=rtpp(SELECT_TRIGGER);
        SELECT_TRIGGER_DATA=rtpp(SELECT_TRIGGER_DATA);
        SELECT_TRIGGER_STATE=rtpp(SELECT_TRIGGER_STATE);
        SELECT_TRIGGER_STATUS=rtpp(SELECT_TRIGGER_STATUS);
        SELECT_NUM_TRIGGERS=rtpp(SELECT_NUM_TRIGGERS);
        SELECT_NUM_TRIGGERS_IN_GROUP=rtpp(SELECT_NUM_TRIGGERS_IN_GROUP);
        SELECT_TRIGGER_GROUPS=rtpp(SELECT_TRIGGER_GROUPS);
        SELECT_TRIGGER_GROUPS_FILTERED=rtpp(SELECT_TRIGGER_GROUPS_FILTERED);
        SELECT_TRIGGERS_IN_GROUP_LIKE=rtpp(SELECT_TRIGGERS_IN_GROUP_LIKE);
        SELECT_TRIGGERS_IN_GROUP=rtpp(SELECT_TRIGGERS_IN_GROUP);
        SELECT_REFERENCED_CALENDAR=rtpp(SELECT_REFERENCED_CALENDAR);
        SELECT_NEXT_FIRE_TIME=rtpp(SELECT_NEXT_FIRE_TIME);
        SELECT_TRIGGER_FOR_FIRE_TIME=rtpp(SELECT_TRIGGER_FOR_FIRE_TIME);
        SELECT_NEXT_TRIGGER_TO_ACQUIRE=rtpp(SELECT_NEXT_TRIGGER_TO_ACQUIRE);*/
    }

    protected final String rtpp(String query) {
        return rtpp(query, tablePrefix, getSchedulerNameLiteral(), "'" + ServiceManager.getServiceConf().getIdc() + "'");
    }

    public static String rtpp(String query, String tablePrefix, String schedNameLiteral, String idc) {
        return MessageFormat.format(query, tablePrefix, schedNameLiteral, idc);
    }

    public OperableTrigger selectTrigger(Connection conn, TriggerKey triggerKey) throws SQLException, ClassNotFoundException,
            IOException, JobPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            OperableTrigger trigger = null;

            ps = conn.prepareStatement(rtpp(SELECT_TRIGGER));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            rs = ps.executeQuery();

            if (rs.next()) {
                String jobName = rs.getString(COL_JOB_NAME);
                String jobGroup = rs.getString(COL_JOB_GROUP);
                String description = rs.getString(COL_DESCRIPTION);
                long nextFireTime = rs.getLong(COL_NEXT_FIRE_TIME);
                long prevFireTime = rs.getLong(COL_PREV_FIRE_TIME);
                String triggerType = rs.getString(COL_TRIGGER_TYPE);
                long startTime = rs.getLong(COL_START_TIME);
                long endTime = rs.getLong(COL_END_TIME);
                String calendarName = rs.getString(COL_CALENDAR_NAME);
                int misFireInstr = rs.getInt(COL_MISFIRE_INSTRUCTION);
                int priority = rs.getInt(COL_PRIORITY);

                Map<?, ?> map = null;
                if (canUseProperties()) {
                    map = getMapFromProperties(rs);
                } else {
                    map = (Map<?, ?>) getObjectFromBlob(rs, COL_JOB_DATAMAP);
                }

                Date nft = null;
                if (nextFireTime > 0) {
                    nft = new Date(nextFireTime);
                }

                Date pft = null;
                if (prevFireTime > 0) {
                    pft = new Date(prevFireTime);
                }
                Date startTimeD = new Date(startTime);
                Date endTimeD = null;
                if (endTime > 0) {
                    endTimeD = new Date(endTime);
                }

                if (triggerType.equals(TTYPE_BLOB)) {
                    rs.close();
                    rs = null;
                    ps.close();
                    ps = null;

                    ps = conn.prepareStatement(rtpp(SELECT_BLOB_TRIGGER));
                    ps.setString(1, triggerKey.getName());
                    ps.setString(2, triggerKey.getGroup());
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        trigger = (OperableTrigger) getObjectFromBlob(rs, COL_BLOB);
                    }
                } else {
                    TriggerPersistenceDelegate tDel = findTriggerPersistenceDelegate(triggerType);

                    if (tDel == null)
                        throw new JobPersistenceException("No TriggerPersistenceDelegate for trigger discriminator type: " + triggerType);

                    TriggerPersistenceDelegate.TriggerPropertyBundle triggerProps = null;
                    try {
                        triggerProps = tDel.loadExtendedTriggerProperties(conn, triggerKey);
                    } catch (IllegalStateException isex) {
                        if (isTriggerStillPresent(ps)) {
                            throw isex;
                        } else {
                            // QTZ-386 Trigger has been deleted
                            return null;
                        }
                    }

                    TriggerBuilder<?> tb = newTrigger()
                            .withDescription(description)
                            .withPriority(priority)
                            .startAt(startTimeD)
                            .endAt(endTimeD)
                            .withIdentity(triggerKey)
                            .modifiedByCalendar(calendarName)
                            .withSchedule(triggerProps.getScheduleBuilder())
                            .forJob(jobKey(jobName, jobGroup));

                    if (null != map) {
                        tb.usingJobData(new JobDataMap(map));
                    }

                    trigger = (OperableTrigger) tb.build();

                    trigger.setMisfireInstruction(misFireInstr);
                    trigger.setNextFireTime(nft);
                    trigger.setPreviousFireTime(pft);
                    setTriggerStateProperties(trigger, triggerProps);
                }
            }

            return trigger;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    /**
     * <p>
     * Get the names of all of the triggers that have misfired.
     * </p>
     *
     * @param conn the DB Connection
     * @return an array of <code>{@link
     * org.quartz.utils.Key}</code> objects
     */
    public List<TriggerKey> selectMisfiredTriggers(Connection conn, long ts)
            throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_MISFIRED_TRIGGERS));
            ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
            rs = ps.executeQuery();

            LinkedList<TriggerKey> list = new LinkedList<TriggerKey>();
            while (rs.next()) {
                String triggerName = rs.getString(COL_TRIGGER_NAME);
                String groupName = rs.getString(COL_TRIGGER_GROUP);
                list.add(TriggerKey.triggerKey(triggerName, groupName));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    /**
     * <p>
     * Select all of the triggers in a given state.
     * </p>
     *
     * @param conn  the DB Connection
     * @param state the state the triggers must be in
     * @return an array of trigger <code>Key</code> s
     */
    public List<TriggerKey> selectTriggersInState(Connection conn, String state)
            throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_TRIGGERS_IN_STATE));
            ps.setString(1, state);
            rs = ps.executeQuery();

            LinkedList<TriggerKey> list = new LinkedList<TriggerKey>();
            while (rs.next()) {
                list.add(TriggerKey.triggerKey(rs.getString(1), rs.getString(2)));
            }

            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    public List<TriggerKey> selectMisfiredTriggersInState(Connection conn, String state,
                                                          long ts) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_MISFIRED_TRIGGERS_IN_STATE));
            ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
            ps.setString(2, state);
            rs = ps.executeQuery();

            LinkedList<TriggerKey> list = new LinkedList<TriggerKey>();
            while (rs.next()) {
                String triggerName = rs.getString(COL_TRIGGER_NAME);
                String groupName = rs.getString(COL_TRIGGER_GROUP);
                list.add(TriggerKey.triggerKey(triggerName, groupName));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    /**
     * <p>
     * Get the number of triggers in the given states that have
     * misfired - according to the given timestamp.
     * </p>
     *
     * @param conn the DB Connection
     */
    public int countMisfiredTriggersInState(
            Connection conn, String state1, long ts) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(COUNT_MISFIRED_TRIGGERS_IN_STATE));
            ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
            ps.setString(2, state1);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            throw new SQLException("No misfired trigger count returned.");
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    /**
     * <p>
     * Get the names of all of the triggers in the given state that have
     * misfired - according to the given timestamp.  No more than count will
     * be returned.
     * </p>
     *
     * @param conn       The DB Connection
     * @param count      The most misfired triggers to return, negative for all
     * @param resultList Output parameter.  A List of
     *                   <code>{@link org.quartz.utils.Key}</code> objects.  Must not be null.
     * @return Whether there are more misfired triggers left to find beyond
     * the given count.
     */
    public boolean hasMisfiredTriggersInState(Connection conn, String state1,
                                              long ts, int count, List<TriggerKey> resultList) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_HAS_MISFIRED_TRIGGERS_IN_STATE));
            ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
            ps.setString(2, state1);
            rs = ps.executeQuery();

            boolean hasReachedLimit = false;
            while (rs.next() && (hasReachedLimit == false)) {
                if (resultList.size() == count) {
                    hasReachedLimit = true;
                } else {
                    String triggerName = rs.getString(COL_TRIGGER_NAME);
                    String groupName = rs.getString(COL_TRIGGER_GROUP);
                    resultList.add(TriggerKey.triggerKey(triggerName, groupName));
                }
            }

            return hasReachedLimit;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    /**
     * <p>
     * Get the names of all of the triggers in the given group and state that
     * have misfired.
     * </p>
     *
     * @param conn the DB Connection
     * @return an array of <code>{@link
     * org.quartz.utils.Key}</code> objects
     */
    public List<TriggerKey> selectMisfiredTriggersInGroupInState(Connection conn,
                                                                 String groupName, String state, long ts) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn
                    .prepareStatement(rtpp(SELECT_MISFIRED_TRIGGERS_IN_GROUP_IN_STATE));
            ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
            ps.setString(2, groupName);
            ps.setString(3, state);
            rs = ps.executeQuery();

            LinkedList<TriggerKey> list = new LinkedList<TriggerKey>();
            while (rs.next()) {
                String triggerName = rs.getString(COL_TRIGGER_NAME);
                list.add(TriggerKey.triggerKey(triggerName, groupName));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    /**
     * <p>
     * Get the names of all of the triggers associated with the given job.
     * </p>
     *
     * @param conn the DB Connection
     * @return an array of <code>{@link
     * org.quartz.utils.Key}</code> objects
     */
    public List<TriggerKey> selectTriggerKeysForJob(Connection conn, JobKey jobKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_TRIGGERS_FOR_JOB));
            ps.setString(1, jobKey.getName());
            ps.setString(2, jobKey.getGroup());
            rs = ps.executeQuery();

            LinkedList<TriggerKey> list = new LinkedList<TriggerKey>();
            while (rs.next()) {
                String trigName = rs.getString(COL_TRIGGER_NAME);
                String trigGroup = rs.getString(COL_TRIGGER_GROUP);
                list.add(TriggerKey.triggerKey(trigName, trigGroup));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    public List<OperableTrigger> selectTriggersForCalendar(Connection conn, String calName)
            throws SQLException, ClassNotFoundException, IOException, JobPersistenceException {

        LinkedList<OperableTrigger> trigList = new LinkedList<OperableTrigger>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_TRIGGERS_FOR_CALENDAR));
            ps.setString(1, calName);
            rs = ps.executeQuery();

            while (rs.next()) {
                trigList.add(selectTrigger(conn, TriggerKey.triggerKey(rs.getString(COL_TRIGGER_NAME), rs.getString(COL_TRIGGER_GROUP))));
            }
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }

        return trigList;
    }

    /**
     * <p>
     * Check whether or not a trigger exists.
     * </p>
     *
     * @param conn the DB Connection
     * @return true if the trigger exists, false otherwise
     */
    public boolean triggerExists(Connection conn, TriggerKey triggerKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_TRIGGER_EXISTENCE));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            rs = ps.executeQuery();

            return rs.next();
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    /**
     * <p>
     * Select the number of triggers associated with a given job.
     * </p>
     *
     * @param conn the DB Connection
     * @return the number of triggers for the given job
     */
    public int selectNumTriggersForJob(Connection conn, JobKey jobKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_NUM_TRIGGERS_FOR_JOB));
            ps.setString(1, jobKey.getName());
            ps.setString(2, jobKey.getGroup());
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    /**
     * <p>
     * Select the job to which the trigger is associated. Allow option to load actual job class or not. When case of
     * remove, we do not need to load the class, which in many cases, it's no longer exists.
     * <p>
     * </p>
     *
     * @param conn the DB Connection
     * @return the <code>{@link org.quartz.JobDetail}</code> object
     * associated with the given trigger
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public JobDetail selectJobForTrigger(Connection conn, ClassLoadHelper loadHelper,
                                         TriggerKey triggerKey, boolean loadJobClass) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_JOB_FOR_TRIGGER));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            rs = ps.executeQuery();

            if (rs.next()) {
                JobDetailImpl job = new JobDetailImpl();
                job.setName(rs.getString(1));
                job.setGroup(rs.getString(2));
                job.setDurability(getBoolean(rs, 3));
                if (loadJobClass)
                    job.setJobClass(loadHelper.loadClass(rs.getString(4), Job.class));
                job.setRequestsRecovery(getBoolean(rs, 5));

                return job;
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("No job for trigger '" + triggerKey + "'.");
                }
                return null;
            }
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    /**
     * <p>
     * Select the triggers for a job
     * </p>
     *
     * @param conn the DB Connection
     * @return an array of <code>(@link org.quartz.Trigger)</code> objects
     * associated with a given job.
     * @throws SQLException
     * @throws JobPersistenceException
     */
    public List<OperableTrigger> selectTriggersForJob(Connection conn, JobKey jobKey) throws SQLException, ClassNotFoundException,
            IOException, JobPersistenceException {

        LinkedList<OperableTrigger> trigList = new LinkedList<OperableTrigger>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_TRIGGERS_FOR_JOB));
            ps.setString(1, jobKey.getName());
            ps.setString(2, jobKey.getGroup());
            rs = ps.executeQuery();

            while (rs.next()) {
                OperableTrigger t = selectTrigger(conn, TriggerKey.triggerKey(rs.getString(COL_TRIGGER_NAME), rs.getString(COL_TRIGGER_GROUP)));
                if (t != null) {
                    trigList.add(t);
                }
            }
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }

        return trigList;
    }

    /**
     * <p>
     * Select a trigger's JobDataMap.
     * </p>
     *
     * @param conn        the DB Connection
     * @param triggerName the name of the trigger
     * @param groupName   the group containing the trigger
     * @return the <code>{@link org.quartz.JobDataMap}</code> of the Trigger,
     * never null, but possibly empty.
     */
    public JobDataMap selectTriggerJobDataMap(Connection conn, String triggerName,
                                              String groupName) throws SQLException, ClassNotFoundException,
            IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_TRIGGER_DATA));
            ps.setString(1, triggerName);
            ps.setString(2, groupName);
            rs = ps.executeQuery();

            if (rs.next()) {

                Map<?, ?> map = null;
                if (canUseProperties()) {
                    map = getMapFromProperties(rs);
                } else {
                    map = (Map<?, ?>) getObjectFromBlob(rs, COL_JOB_DATAMAP);
                }

                rs.close();
                ps.close();

                if (null != map) {
                    return new JobDataMap(map);
                }
            }
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }

        return new JobDataMap();
    }

    /**
     * <p>
     * Select a trigger' state value.
     * </p>
     *
     * @param conn the DB Connection
     * @return the <code>{@link org.quartz.Trigger}</code> object
     */
    public String selectTriggerState(Connection conn, TriggerKey triggerKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String state = null;

            ps = conn.prepareStatement(rtpp(SELECT_TRIGGER_STATE));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            rs = ps.executeQuery();

            if (rs.next()) {
                state = rs.getString(COL_TRIGGER_STATE);
            } else {
                state = STATE_DELETED;
            }

            return state.intern();
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }

    }

    /**
     * <p>
     * Select a trigger' status (state & next fire time).
     * </p>
     *
     * @param conn the DB Connection
     * @return a <code>TriggerStatus</code> object, or null
     */
    public TriggerStatus selectTriggerStatus(Connection conn,
                                             TriggerKey triggerKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            TriggerStatus status = null;

            ps = conn.prepareStatement(rtpp(SELECT_TRIGGER_STATUS));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            rs = ps.executeQuery();

            if (rs.next()) {
                String state = rs.getString(COL_TRIGGER_STATE);
                long nextFireTime = rs.getLong(COL_NEXT_FIRE_TIME);
                String jobName = rs.getString(COL_JOB_NAME);
                String jobGroup = rs.getString(COL_JOB_GROUP);

                Date nft = null;
                if (nextFireTime > 0) {
                    nft = new Date(nextFireTime);
                }

                status = new TriggerStatus(state, nft);
                status.setKey(triggerKey);
                status.setJobKey(JobKey.jobKey(jobName, jobGroup));
            }

            return status;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }

    }

    /**
     * <p>
     * Select the total number of triggers stored.
     * </p>
     *
     * @param conn the DB Connection
     * @return the total number of triggers stored
     */
    public int selectNumTriggers(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int count = 0;
            ps = conn.prepareStatement(rtpp(SELECT_NUM_TRIGGERS));
            rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            return count;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    public boolean isExistingTriggerGroup(Connection conn, String groupName)
            throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_NUM_TRIGGERS_IN_GROUP));
            ps.setString(1, groupName);
            rs = ps.executeQuery();

            if (!rs.next()) {
                return false;
            }

            return (rs.getInt(1) > 0);
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    /**
     * <p>
     * Select all of the trigger group names that are stored.
     * </p>
     *
     * @param conn the DB Connection
     * @return an array of <code>String</code> group names
     */
    public List<String> selectTriggerGroups(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_TRIGGER_GROUPS));
            rs = ps.executeQuery();

            LinkedList<String> list = new LinkedList<String>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }

            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    public List<String> selectTriggerGroups(Connection conn, GroupMatcher<TriggerKey> matcher) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(rtpp(SELECT_TRIGGER_GROUPS_FILTERED));
            ps.setString(1, toSqlLikeClause(matcher));
            rs = ps.executeQuery();

            LinkedList<String> list = new LinkedList<String>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }

            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    public Set<TriggerKey> selectTriggersInGroup(Connection conn, GroupMatcher<TriggerKey> matcher)
            throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            if (isMatcherEquals(matcher)) {
                ps = conn.prepareStatement(rtpp(SELECT_TRIGGERS_IN_GROUP));
                ps.setString(1, toSqlEqualsClause(matcher));
            } else {
                ps = conn.prepareStatement(rtpp(SELECT_TRIGGERS_IN_GROUP_LIKE));
                ps.setString(1, toSqlLikeClause(matcher));
            }
            rs = ps.executeQuery();

            Set<TriggerKey> keys = new HashSet<TriggerKey>();
            while (rs.next()) {
                keys.add(TriggerKey.triggerKey(rs.getString(1), rs.getString(2)));
            }

            return keys;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    public boolean calendarIsReferenced(Connection conn, String calendarName)
            throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtpp(SELECT_REFERENCED_CALENDAR));
            ps.setString(1, calendarName);
            rs = ps.executeQuery();

            return rs.next();
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override
    public TriggerKey selectTriggerForFireTime(Connection conn, long fireTime)
            throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtpp(SELECT_TRIGGER_FOR_FIRE_TIME));
            ps.setString(1, STATE_WAITING);
            ps.setBigDecimal(2, new BigDecimal(String.valueOf(fireTime)));
            rs = ps.executeQuery();

            if (rs.next()) {
                return new TriggerKey(rs.getString(COL_TRIGGER_NAME), rs
                        .getString(COL_TRIGGER_GROUP));
            } else {
                return null;
            }
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    public List<TriggerKey> selectTriggerToAcquire(Connection conn, long noLaterThan, long noEarlierThan, int maxCount)
            throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TriggerKey> nextTriggers = new LinkedList<TriggerKey>();
        try {
            ps = conn.prepareStatement(rtpp(SELECT_NEXT_TRIGGER_TO_ACQUIRE));

            // Set max rows to retrieve
            if (maxCount < 1)
                maxCount = 1; // we want at least one trigger back.
            ps.setMaxRows(maxCount);

            // Try to give jdbc driver a hint to hopefully not pull over more than the few rows we actually need.
            // Note: in some jdbc drivers, such as MySQL, you must set maxRows before fetchSize, or you get exception!
            ps.setFetchSize(maxCount);

            ps.setString(1, STATE_WAITING);
            ps.setBigDecimal(2, new BigDecimal(String.valueOf(noLaterThan)));
            ps.setBigDecimal(3, new BigDecimal(String.valueOf(noEarlierThan)));
            rs = ps.executeQuery();

            while (rs.next() && nextTriggers.size() <= maxCount) {
                nextTriggers.add(TriggerKey.triggerKey(
                        rs.getString(COL_TRIGGER_NAME),
                        rs.getString(COL_TRIGGER_GROUP)));
            }

            return nextTriggers;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    private Map<?, ?> getMapFromProperties(ResultSet rs)
            throws ClassNotFoundException, IOException, SQLException {
        Map<?, ?> map;
        InputStream is = (InputStream) getJobDataFromBlob(rs, COL_JOB_DATAMAP);
        if (is == null) {
            return null;
        }
        Properties properties = new Properties();
        if (is != null) {
            try {
                properties.load(is);
            } finally {
                is.close();
            }
        }
        map = convertFromProperty(properties);
        return map;
    }

    private boolean isTriggerStillPresent(PreparedStatement ps) throws SQLException {
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            return rs.next();
        } finally {
            closeResultSet(rs);
        }
    }

    private void setTriggerStateProperties(OperableTrigger trigger, TriggerPersistenceDelegate.TriggerPropertyBundle props) throws JobPersistenceException {

        if (props.getStatePropertyNames() == null)
            return;

        Util.setBeanProps(trigger, props.getStatePropertyNames(), props.getStatePropertyValues());
    }


    String UPDATE_TRIGGER_STATES_FROM_OTHER_STATES = "UPDATE "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " SET "
            + COL_TRIGGER_STATE
            + " = ?"
            + " WHERE "
            + COL_SCHEDULER_NAME
            + " = " + SCHED_NAME_SUBST + " AND ("
            + COL_TRIGGER_STATE
            + " = ? OR "
            + COL_TRIGGER_STATE + " = ?)";

    String DELETE_FIRED_TRIGGERS = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS
            + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;

    String INSERT_JOB_DETAIL = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " ("
            + COL_SCHEDULER_NAME + ", " + COL_JOB_NAME
            + ", " + COL_JOB_GROUP + ", " + COL_DESCRIPTION + ", "
            + COL_JOB_CLASS + ", " + COL_IS_DURABLE + ", "
            + COL_IS_NONCONCURRENT + ", " + COL_IS_UPDATE_DATA + ", "
            + COL_REQUESTS_RECOVERY + ", "
            + COL_JOB_DATAMAP + ") " + " VALUES(" + SCHED_NAME_SUBST + ", ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String UPDATE_JOB_DETAIL = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " SET "
            + COL_DESCRIPTION + " = ?, " + COL_JOB_CLASS + " = ?, "
            + COL_IS_DURABLE + " = ?, "
            + COL_IS_NONCONCURRENT + " = ?, " + COL_IS_UPDATE_DATA + " = ?, "
            + COL_REQUESTS_RECOVERY + " = ?, "
            + COL_JOB_DATAMAP + " = ? " + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME
            + " = ? AND " + COL_JOB_GROUP + " = ?";

    String DELETE_JOB_DETAIL = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME
            + " = ? AND " + COL_JOB_GROUP + " = ?";

    String SELECT_JOB_NONCONCURRENT = "SELECT "
            + COL_IS_NONCONCURRENT + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_JOB_DETAILS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME
            + " = ? AND " + COL_JOB_GROUP + " = ?";

    String SELECT_JOB_EXISTENCE = "SELECT " + COL_JOB_NAME
            + " FROM " + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME
            + " = ? AND " + COL_JOB_GROUP + " = ?";

    String UPDATE_JOB_DATA = "UPDATE " + TABLE_PREFIX_SUBST
            + TABLE_JOB_DETAILS + " SET " + COL_JOB_DATAMAP + " = ? "
            + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME
            + " = ? AND " + COL_JOB_GROUP + " = ?";

    String SELECT_JOB_DETAIL = "SELECT *" + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME
            + " = ? AND " + COL_JOB_GROUP + " = ?";


    String SELECT_NUM_JOBS = "SELECT COUNT(" + COL_JOB_NAME
            + ") " + " FROM " + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;

    String SELECT_JOB_GROUPS = "SELECT DISTINCT("
            + COL_JOB_GROUP + ") FROM " + TABLE_PREFIX_SUBST
            + TABLE_JOB_DETAILS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;

    String SELECT_JOBS_IN_GROUP_LIKE = "SELECT " + COL_JOB_NAME + ", " + COL_JOB_GROUP
            + " FROM " + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_GROUP + " LIKE ?";

    String SELECT_JOBS_IN_GROUP = "SELECT " + COL_JOB_NAME + ", " + COL_JOB_GROUP
            + " FROM " + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_GROUP + " = ?";

    String INSERT_TRIGGER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " (" + COL_SCHEDULER_NAME + ", " + COL_TRIGGER_NAME
            + ", " + COL_TRIGGER_GROUP + ", " + COL_JOB_NAME + ", "
            + COL_JOB_GROUP + ", " + COL_DESCRIPTION
            + ", " + COL_NEXT_FIRE_TIME + ", " + COL_PREV_FIRE_TIME + ", "
            + COL_TRIGGER_STATE + ", " + COL_TRIGGER_TYPE + ", "
            + COL_START_TIME + ", " + COL_END_TIME + ", " + COL_CALENDAR_NAME
            + ", " + COL_MISFIRE_INSTRUCTION + ", " + COL_JOB_DATAMAP + ", " + COL_PRIORITY + ") "
            + " VALUES(" + SCHED_NAME_SUBST + ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String INSERT_SIMPLE_TRIGGER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_SIMPLE_TRIGGERS + " ("
            + COL_SCHEDULER_NAME + ", "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + ", "
            + COL_REPEAT_COUNT + ", " + COL_REPEAT_INTERVAL + ", "
            + COL_TIMES_TRIGGERED + ") " + " VALUES(" + SCHED_NAME_SUBST + ", ?, ?, ?, ?, ?)";

    String INSERT_CRON_TRIGGER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_CRON_TRIGGERS + " ("
            + COL_SCHEDULER_NAME + ", "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + ", "
            + COL_CRON_EXPRESSION + ", " + COL_TIME_ZONE_ID + ") "
            + " VALUES(" + SCHED_NAME_SUBST + ", ?, ?, ?, ?)";

    String INSERT_BLOB_TRIGGER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_BLOB_TRIGGERS + " ("
            + COL_SCHEDULER_NAME + ", "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + ", " + COL_BLOB
            + ") " + " VALUES(" + SCHED_NAME_SUBST + ", ?, ?, ?)";

    String UPDATE_TRIGGER_SKIP_DATA = "UPDATE " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " SET " + COL_JOB_NAME + " = ?, "
            + COL_JOB_GROUP + " = ?, "
            + COL_DESCRIPTION + " = ?, " + COL_NEXT_FIRE_TIME + " = ?, "
            + COL_PREV_FIRE_TIME + " = ?, " + COL_TRIGGER_STATE + " = ?, "
            + COL_TRIGGER_TYPE + " = ?, " + COL_START_TIME + " = ?, "
            + COL_END_TIME + " = ?, " + COL_CALENDAR_NAME + " = ?, "
            + COL_MISFIRE_INSTRUCTION + " = ?, " + COL_PRIORITY
            + " = ? WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME
            + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String UPDATE_TRIGGER = "UPDATE " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " SET " + COL_JOB_NAME + " = ?, "
            + COL_JOB_GROUP + " = ?, "
            + COL_DESCRIPTION + " = ?, " + COL_NEXT_FIRE_TIME + " = ?, "
            + COL_PREV_FIRE_TIME + " = ?, " + COL_TRIGGER_STATE + " = ?, "
            + COL_TRIGGER_TYPE + " = ?, " + COL_START_TIME + " = ?, "
            + COL_END_TIME + " = ?, " + COL_CALENDAR_NAME + " = ?, "
            + COL_MISFIRE_INSTRUCTION + " = ?, " + COL_PRIORITY + " = ?, "
            + COL_JOB_DATAMAP + " = ? WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String UPDATE_SIMPLE_TRIGGER = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_SIMPLE_TRIGGERS + " SET "
            + COL_REPEAT_COUNT + " = ?, " + COL_REPEAT_INTERVAL + " = ?, "
            + COL_TIMES_TRIGGERED + " = ? WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME
            + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String UPDATE_CRON_TRIGGER = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_CRON_TRIGGERS + " SET "
            + COL_CRON_EXPRESSION + " = ?, " + COL_TIME_ZONE_ID
            + " = ? WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME
            + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String UPDATE_BLOB_TRIGGER = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_BLOB_TRIGGERS + " SET " + COL_BLOB
            + " = ? WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND "
            + COL_TRIGGER_GROUP + " = ?";

    String UPDATE_TRIGGER_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " SET " + COL_TRIGGER_STATE
            + " = ?" + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND "
            + COL_TRIGGER_GROUP + " = ?";

    String UPDATE_TRIGGER_STATE_FROM_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " SET " + COL_TRIGGER_STATE
            + " = ?" + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND "
            + COL_TRIGGER_GROUP + " = ? AND " + COL_TRIGGER_STATE + " = ?";

    String UPDATE_TRIGGER_GROUP_STATE_FROM_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " SET "
            + COL_TRIGGER_STATE
            + " = ?"
            + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_GROUP
            + " LIKE ? AND "
            + COL_TRIGGER_STATE + " = ?";

    String UPDATE_TRIGGER_STATE_FROM_STATES = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " SET " + COL_TRIGGER_STATE
            + " = ?" + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND "
            + COL_TRIGGER_GROUP + " = ? AND (" + COL_TRIGGER_STATE + " = ? OR "
            + COL_TRIGGER_STATE + " = ? OR " + COL_TRIGGER_STATE + " = ?)";

    String UPDATE_TRIGGER_GROUP_STATE_FROM_STATES = "UPDATE "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " SET "
            + COL_TRIGGER_STATE
            + " = ?"
            + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_GROUP
            + " LIKE ? AND ("
            + COL_TRIGGER_STATE
            + " = ? OR "
            + COL_TRIGGER_STATE
            + " = ? OR "
            + COL_TRIGGER_STATE + " = ?)";

    String UPDATE_JOB_TRIGGER_STATES = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " SET " + COL_TRIGGER_STATE
            + " = ? WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME + " = ? AND " + COL_JOB_GROUP
            + " = ?";

    String UPDATE_JOB_TRIGGER_STATES_FROM_OTHER_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " SET "
            + COL_TRIGGER_STATE
            + " = ? WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME
            + " = ? AND "
            + COL_JOB_GROUP
            + " = ? AND " + COL_TRIGGER_STATE + " = ?";

    String DELETE_SIMPLE_TRIGGER = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_SIMPLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String DELETE_CRON_TRIGGER = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_CRON_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String DELETE_BLOB_TRIGGER = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_BLOB_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String DELETE_TRIGGER = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String SELECT_SIMPLE_TRIGGER = "SELECT *" + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_SIMPLE_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String SELECT_CRON_TRIGGER = "SELECT *" + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_CRON_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String INSERT_CALENDAR = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_CALENDARS + " (" + COL_SCHEDULER_NAME + ", " + COL_CALENDAR_NAME
            + ", " + COL_CALENDAR + ") " + " VALUES(" + SCHED_NAME_SUBST + ", ?, ?)";

    String UPDATE_CALENDAR = "UPDATE " + TABLE_PREFIX_SUBST
            + TABLE_CALENDARS + " SET " + COL_CALENDAR + " = ? " + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_CALENDAR_NAME + " = ?";

    String SELECT_CALENDAR_EXISTENCE = "SELECT "
            + COL_CALENDAR_NAME + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_CALENDARS + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_CALENDAR_NAME + " = ?";

    String SELECT_CALENDAR = "SELECT *" + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_CALENDARS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_CALENDAR_NAME + " = ?";

    String DELETE_CALENDAR = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_CALENDARS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_CALENDAR_NAME + " = ?";

    String SELECT_NUM_CALENDARS = "SELECT COUNT("
            + COL_CALENDAR_NAME + ") " + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_CALENDARS + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;

    String SELECT_CALENDARS = "SELECT " + COL_CALENDAR_NAME
            + " FROM " + TABLE_PREFIX_SUBST + TABLE_CALENDARS
            + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;

    String INSERT_FIRED_TRIGGER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " (" + COL_SCHEDULER_NAME + ", " + COL_ENTRY_ID
            + ", " + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + ", "
            + COL_INSTANCE_NAME + ", "
            + COL_FIRED_TIME + ", " + COL_SCHED_TIME + ", " + COL_ENTRY_STATE + ", " + COL_JOB_NAME
            + ", " + COL_JOB_GROUP + ", " + COL_IS_NONCONCURRENT + ", "
            + COL_REQUESTS_RECOVERY + ", " + COL_PRIORITY
            + ") VALUES(" + SCHED_NAME_SUBST + ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String UPDATE_FIRED_TRIGGER = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " SET "
            + COL_INSTANCE_NAME + " = ?, "
            + COL_FIRED_TIME + " = ?, " + COL_SCHED_TIME + " = ?, " + COL_ENTRY_STATE + " = ?, " + COL_JOB_NAME
            + " = ?, " + COL_JOB_GROUP + " = ?, " + COL_IS_NONCONCURRENT + " = ?, "
            + COL_REQUESTS_RECOVERY + " = ? WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_ENTRY_ID + " = ?";

    String SELECT_INSTANCES_FIRED_TRIGGERS = "SELECT * FROM "
            + TABLE_PREFIX_SUBST
            + TABLE_FIRED_TRIGGERS
            + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_INSTANCE_NAME + " = ?";

    String SELECT_INSTANCES_RECOVERABLE_FIRED_TRIGGERS = "SELECT * FROM "
            + TABLE_PREFIX_SUBST
            + TABLE_FIRED_TRIGGERS
            + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_INSTANCE_NAME + " = ? AND " + COL_REQUESTS_RECOVERY + " = ?";

    String SELECT_JOB_EXECUTION_COUNT = "SELECT COUNT("
            + COL_TRIGGER_NAME + ") FROM " + TABLE_PREFIX_SUBST
            + TABLE_FIRED_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME + " = ? AND "
            + COL_JOB_GROUP + " = ?";

    String SELECT_FIRED_TRIGGERS = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS
            + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;

    String SELECT_FIRED_TRIGGER = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ?";

    String SELECT_FIRED_TRIGGER_GROUP = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_GROUP + " = ?";

    String SELECT_FIRED_TRIGGERS_OF_JOB = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_NAME + " = ? AND " + COL_JOB_GROUP + " = ?";

    String SELECT_FIRED_TRIGGERS_OF_JOB_GROUP = "SELECT * FROM "
            + TABLE_PREFIX_SUBST
            + TABLE_FIRED_TRIGGERS
            + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_JOB_GROUP + " = ?";

    String DELETE_FIRED_TRIGGER = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_ENTRY_ID + " = ?";

    String DELETE_INSTANCES_FIRED_TRIGGERS = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_INSTANCE_NAME + " = ?";

    String DELETE_NO_RECOVERY_FIRED_TRIGGERS = "DELETE FROM "
            + TABLE_PREFIX_SUBST
            + TABLE_FIRED_TRIGGERS
            + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_INSTANCE_NAME + " = ?" + COL_REQUESTS_RECOVERY + " = ?";

    String DELETE_ALL_SIMPLE_TRIGGERS = "DELETE FROM " + TABLE_PREFIX_SUBST + "SIMPLE_TRIGGERS " + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;
    String DELETE_ALL_SIMPROP_TRIGGERS = "DELETE FROM " + TABLE_PREFIX_SUBST + "SIMPROP_TRIGGERS " + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;
    String DELETE_ALL_CRON_TRIGGERS = "DELETE FROM " + TABLE_PREFIX_SUBST + "CRON_TRIGGERS" + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;
    String DELETE_ALL_BLOB_TRIGGERS = "DELETE FROM " + TABLE_PREFIX_SUBST + "BLOB_TRIGGERS" + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;
    String DELETE_ALL_TRIGGERS = "DELETE FROM " + TABLE_PREFIX_SUBST + "TRIGGERS" + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;
    String DELETE_ALL_JOB_DETAILS = "DELETE FROM " + TABLE_PREFIX_SUBST + "JOB_DETAILS" + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;
    String DELETE_ALL_CALENDARS = "DELETE FROM " + TABLE_PREFIX_SUBST + "CALENDARS" + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;
    String DELETE_ALL_PAUSED_TRIGGER_GRPS = "DELETE FROM " + TABLE_PREFIX_SUBST + "PAUSED_TRIGGER_GRPS" + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;

    String SELECT_FIRED_TRIGGER_INSTANCE_NAMES =
            "SELECT DISTINCT " + COL_INSTANCE_NAME + " FROM "
                    + TABLE_PREFIX_SUBST
                    + TABLE_FIRED_TRIGGERS
                    + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;

    String INSERT_SCHEDULER_STATE = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_SCHEDULER_STATE + " ("
            + COL_SCHEDULER_NAME + ", "
            + COL_INSTANCE_NAME + ", " + COL_LAST_CHECKIN_TIME + ", "
            + COL_CHECKIN_INTERVAL + ") VALUES(" + SCHED_NAME_SUBST + ", ?, ?, ?)";

    String SELECT_SCHEDULER_STATE = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_SCHEDULER_STATE + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_INSTANCE_NAME + " = ?";

    String SELECT_SCHEDULER_STATES = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_SCHEDULER_STATE
            + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;

    String DELETE_SCHEDULER_STATE = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_SCHEDULER_STATE + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_INSTANCE_NAME + " = ?";

    String UPDATE_SCHEDULER_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_SCHEDULER_STATE + " SET "
            + COL_LAST_CHECKIN_TIME + " = ? WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_INSTANCE_NAME + " = ?";

    String INSERT_PAUSED_TRIGGER_GROUP = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_PAUSED_TRIGGERS + " ("
            + COL_SCHEDULER_NAME + ", "
            + COL_TRIGGER_GROUP + ") VALUES(" + SCHED_NAME_SUBST + ", ?)";

    String SELECT_PAUSED_TRIGGER_GROUP = "SELECT "
            + COL_TRIGGER_GROUP + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_PAUSED_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_GROUP + " = ?";

    String SELECT_PAUSED_TRIGGER_GROUPS = "SELECT "
            + COL_TRIGGER_GROUP + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_PAUSED_TRIGGERS
            + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;

    String DELETE_PAUSED_TRIGGER_GROUP = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_PAUSED_TRIGGERS + " WHERE "
            + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
            + " AND " + COL_TRIGGER_GROUP + " LIKE ?";

    String DELETE_PAUSED_TRIGGER_GROUPS = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_PAUSED_TRIGGERS
            + " WHERE " + COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST;

}
