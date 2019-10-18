
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.soul.commons.enums.SupportTerminal" %>
<%@ page import="org.soul.commons.lang.string.StringTool" %>
<%@ page import="org.soul.commons.spring.utils.SpringTool" %>
<%@ page import="org.soul.web.session.RedisSessionDao" %>
<%@ page import="so.wwb.lotterybox.model.enums.user.UserTypeEnum" %>
<%@ page import="so.wwb.lotterybox.model.manager.sys.po.VSysSiteManage" %>
<%@ page import="java.text.MessageFormat" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<li class="infos show-info">
    <a onclick="showUsersUL()" href="javascript:void(0);" style="float: right;max-width: 285px; padding-right: 0px;
    margin-right: 0px;">
        <%
            RedisSessionDao redisSessionDao= (RedisSessionDao) SpringTool.getBean("redisSessionDao");
            List<VSysSiteManage> sites=(List<VSysSiteManage>)request.getAttribute("sites");

            Set<String> bossActiveSession = redisSessionDao.getActiveSessions(UserTypeEnum.BOSS.getCode());
            Integer bCount= bossActiveSession == null ? 0: bossActiveSession.size();
            Integer bSubCount= redisSessionDao.getActiveSessions(UserTypeEnum.BOSS_SUB.getCode()).size();
            Integer cCount= redisSessionDao.getActiveSessions(UserTypeEnum.COMPANY.getCode()).size();
            Integer cSubCount= redisSessionDao.getActiveSessions(UserTypeEnum.COMPANY_SUB.getCode()).size();
            Set<String> mUsers= redisSessionDao.getActiveSessions(UserTypeEnum.SHAREHOLDER.getCode());
            Set<String> mSubUsers= redisSessionDao.getActiveSessions(UserTypeEnum.SHAREHOLDER_SUB.getCode());
            Set<String> tUsers= redisSessionDao.getActiveSessions(UserTypeEnum.DISTRIBUTOR.getCode());
            Set<String> tSubUsers= redisSessionDao.getActiveSessions(UserTypeEnum.DISTRIBUTOR_SUB.getCode());
            /*Set<String> aUsers= redisSessionDao.getActiveSessions(UserTypeEnum.AGENT.getCode());
            Set<String> aUsbUsers= redisSessionDao.getActiveSessions(UserTypeEnum.AGENT_SUB.getCode());*/
            Set<String> pUsers= redisSessionDao.getActiveSessions(UserTypeEnum.PLAYER.getCode());
            Set<String> guestUsers= redisSessionDao.getActiveGuestSessions();

            Integer mCount=mUsers.size();
            Integer mSubCount=mSubUsers.size();
            Integer tCount=tUsers.size();
            Integer tSubCount=tSubUsers.size();
           /* Integer aCount=aUsers.size();
            Integer aSubCount=aUsbUsers.size();*/
            Integer pGuestCount=guestUsers.size();
            Integer pCount=0;
            Integer pCountPC=0;
            Integer pCountH5 =0;
            Integer pCountAA=0;
            Integer pCountAI=0;
            Integer rGuestCount=0;
            Integer rGuestCountPC=0;
            Integer rGuestCountH5=0;
            Integer rGuestCountAA=0;
            Integer rGuestCountAI=0;

            Map<Integer,Set<String>> guest=new HashMap();
            Map<Integer,Set<String>> pSite=new HashMap();
            Map<Integer,Map<String,Integer>> users=new HashMap();


            for (VSysSiteManage site : sites) {
                pSite.put(site.getId(),new HashSet<String>());
                guest.put(site.getId(),new HashSet<String>());
                users.put(site.getId(),new HashMap<String,Integer>());
                users.get(site.getId()).put("mSite",0);
                users.get(site.getId()).put("mSubSite",0);
                users.get(site.getId()).put("tSite",0);
                users.get(site.getId()).put("tSubSite",0);
                users.get(site.getId()).put("aSite",0);
                users.get(site.getId()).put("aSubSite",0);
                users.get(site.getId()).put("pSite",0);
                users.get(site.getId()).put("pSitePC",0);
                users.get(site.getId()).put("pSiteH5",0);
                users.get(site.getId()).put("pSiteAA",0);
                users.get(site.getId()).put("pSiteAI",0);
                users.get(site.getId()).put("pGuest",0);
                users.get(site.getId()).put("pGuestPC",0);
                users.get(site.getId()).put("pGuestH5",0);
                users.get(site.getId()).put("pGuestAA",0);
                users.get(site.getId()).put("pGuestAI",0);
                users.get(site.getId()).put("rGuest",0);
            }
            //session:上级ID，自己ID，站点ID：.......
            for (String sKey : mUsers) {
                String strSiteId = sKey.substring(sKey.indexOf(":"), sKey.lastIndexOf(":")).split(",")[2];
                if (!strSiteId.equals("null")){
                    int siteId = Integer.parseInt(strSiteId);
                    if(!users.containsKey(siteId)){
                        continue;
                    }
                    users.get(siteId).put("mSite",users.get(siteId).get("mSite")+1);
                }

            }
            for (String sKey : mSubUsers) {
                String strSiteId = sKey.substring(sKey.indexOf(":"), sKey.lastIndexOf(":")).split(",")[2];
                if (!strSiteId.equals("null")){
                    int siteId = Integer.parseInt(strSiteId);
                    if(!users.containsKey(siteId)){
                        continue;
                    }
                    users.get(siteId).put("mSubSite",users.get(siteId).get("mSubSite")+1);
                }

            }//session:上级ID，自己ID，站点ID：.......
            for (String sKey : tUsers) {
                String strSiteId = sKey.substring(sKey.indexOf(":"), sKey.lastIndexOf(":")).split(",")[2];
                if (!strSiteId.equals("null")){
                    int siteId = Integer.parseInt(strSiteId);
                    if (!users.containsKey(siteId)){
                        continue;
                    }
                    users.get(siteId).put("tSite",users.get(siteId).get("tSite")+1);
                }

            }
            for (String sKey : tSubUsers) {
                String strSiteId = sKey.substring(sKey.indexOf(":"), sKey.lastIndexOf(":")).split(",")[2];
                if (!strSiteId.equals("null")){
                    Integer siteId= Integer.parseInt(strSiteId);
                    if(!users.containsKey(siteId)){
                        continue;
                    }
                    users.get(siteId).put("tSubSite",users.get(siteId).get("tSubSite")+1);
                }

            }
            /*for (String sKey : aUsers) {
                Integer siteId= Integer.parseInt(sKey.substring(sKey.indexOf(":"),sKey.lastIndexOf(":")).split(",")[2]);
                if(!users.containsKey(siteId)){
                    continue;
                }
                users.get(siteId).put("aSite",users.get(siteId).get("aSite")+1);
            }
            for (String sKey : aUsbUsers) {
                Integer siteId= Integer.parseInt(sKey.substring(sKey.indexOf(":"),sKey.lastIndexOf(":")).split(",")[2]);
                if(!users.containsKey(siteId)){
                    continue;
                }
                users.get(siteId).put("aSubSite",users.get(siteId).get("aSubSite")+1);
            }*/
            //session:上级ID，自己ID，站点ID：.......
            for (String sKey : pUsers) {
                String strSiteId=sKey.substring(sKey.indexOf(":"),sKey.lastIndexOf(":")).split(",")[2];
                if(StringTool.isBlank(strSiteId) || strSiteId.equals("null")){
                    continue;
                }
                Integer siteId= Integer.parseInt(strSiteId);
                if(!users.containsKey(siteId)){
                    continue;
                }
                String terminal="1";
                if(sKey.lastIndexOf("_")>0){
                    terminal=sKey.substring(sKey.lastIndexOf("_")+1);
                }
                //玩家去重
                pSite.get(siteId).add(MessageFormat.format("{0}_{1}",
                        sKey.substring(0, sKey.lastIndexOf(",")),terminal.equals("null")?"1":terminal));
            }
            for (String sKey : guestUsers) {
                String[] keys=sKey.substring(sKey.indexOf(":"),sKey.lastIndexOf(":")).split(",");
                if(StringTool.isNotBlank(keys[2]) && !keys[2].equals("null")) {
                    Integer siteId = Integer.parseInt(keys[2]);
                    if (users.get(siteId) != null) {
                        users.get(siteId).put("pGuest", users.get(siteId).get("pGuest") + 1);
                        String terminal = sKey.substring(sKey.lastIndexOf("_")+1);
                        if(StringTool.isBlank(terminal) || terminal.equals("null")){
                            terminal = "1";
                        }
                        SupportTerminal terminal1=SupportTerminal.enumOf(terminal);

                        switch (terminal1) {
                            case H5:
                                rGuestCountH5++;
                                users.get(siteId).put("pGuestH5",users.get(siteId).get("pGuestH5")+1);
                                break;
                            case IOSAPP:
                                rGuestCountAI++;
                                users.get(siteId).put("pGuestAI",users.get(siteId).get("pGuestAI")+1);
                                break;
                            case ANDROID:
                                rGuestCountAA++;
                                users.get(siteId).put("pGuestAA",users.get(siteId).get("pGuestAA")+1);
                                break;
                            default:
                                rGuestCountPC++;
                                users.get(siteId).put("pGuestPC",users.get(siteId).get("pGuestPC")+1);
                                break;
                        }
                        //游客去重
                        guest.get(siteId).add(MessageFormat.format("{0}_{1}",
                                sKey.substring(0, sKey.lastIndexOf(",")), terminal.equals("null")?"1":terminal));
                    }
                }
            }
            //设置去重游客总数量 session:上级ID，自己ID，站点ID：.......
            for (Integer siteId: guest.keySet()) {
                users.get(siteId).put("rGuest",guest.get(siteId).size());
                rGuestCount+=guest.get(siteId).size();
            }
            //设置去重玩家总数量
            for (Integer siteId: pSite.keySet()) {
                users.get(siteId).put("pSite",pSite.get(siteId).size());
                pCount+=pSite.get(siteId).size();
                for (String userKey : pSite.get(siteId)) {

                    String terminal = userKey.split("_")[1];
                    if(StringTool.isBlank(terminal) || terminal.equals("null")){
                        terminal = "1";
                    }

                    SupportTerminal terminal1=SupportTerminal.enumOf(terminal);

                    switch (terminal1) {
                        case H5:
                            pCountH5++;
                            users.get(siteId).put("pSiteH5",users.get(siteId).get("pSiteH5")+1);
                            break;
                        case IOSAPP:
                            pCountAI++;
                            users.get(siteId).put("pSiteAI",users.get(siteId).get("pSiteAI")+1);
                            break;
                        case ANDROID:
                            pCountAA++;
                            users.get(siteId).put("pSiteAA",users.get(siteId).get("pSiteAA")+1);
                            break;
                        default:
                            pCountPC++;
                            users.get(siteId).put("pSitePC",users.get(siteId).get("pSitePC")+1);
                            break;
                    }
                }
            }
        %>
        <%--玩家:<%= pCount %>_<%= pCountPC %>_<%= pCountH5 %>_<%= pCountAA %>_<%= pCountAI %> |
        IP游客:<%= rGuestCount %> |
        游客:<%= pGuestCount %>_<%= rGuestCountPC %>_<%= rGuestCountH5 %>_<%= rGuestCountAA %>_<%= rGuestCountAI %>--%>
        总在线:<%= bCount+bSubCount+cCount+cSubCount+mCount+mSubCount+tCount+tSubCount+pCount %>
    </a>
    <ul id="userOnlineUL" class="information nav-shadow" style="width: 777px;right:-108px;
            position: absolute;z-index:9999;background-color: white;top:42px;">
        <c:set var="users" value='<%=users%>'/>
        <li style="color: #2ea8e5;">
            <table id="userOnlineTable" style="cursor: pointer" class="table table-striped table-hover dataTable" cellpadding="0" cellspacing="0">
                <thead style="overflow: auto;display: block;">
                <tr>
                    <td colspan="12" style="padding: 0px;">
                        <table class="table" cellpadding="0" cellspacing="0">
                            <thead style="height: 30px; background-color: burlywood;">
                            <tr>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">总控</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">商户</th>
                                <th style="width:50px;height:30px;padding: 0;text-align: right;">股东</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">总代</th>
                                <%--<th style="width:50px;height:30px;padding: 0;text-align: right;">代理</th>--%>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">玩家</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">PC</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">移动</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">安卓</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">IOS</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">IP游客</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">游客</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">PC</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">移动</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">安卓</th>
                                <th style="width:35px;height:30px;padding: 0;text-align: right;">IOS</th>
                                <th style="width:50px;height:30px;padding: 0;text-align: center;">总在线</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr style="background-color: transparent;">
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= bCount %>_<%= bSubCount %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= cCount %>_<%= cSubCount %></td>
                                <td style="width:50px;height:30px;padding: 0;text-align: right;"><%= mCount %>_<%= mSubCount %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= tCount %>_<%= tSubCount %></td>
                                <%--
                                   <td style="width:50px;height:30px;padding: 0;text-align: right;"><%= aCount %>_<%= aSubCount %></td>
                                --%>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= pCount %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= pCountPC %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= pCountH5 %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= pCountAA %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= pCountAI %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= rGuestCount %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= pGuestCount %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= rGuestCountPC %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= rGuestCountH5 %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= rGuestCountAA %></td>
                                <td style="width:35px;height:30px;padding: 0;text-align: right;"><%= rGuestCountAI %></td>
                                <td style="width:50px;height:30px;padding: 0;text-align: center;">
                                    <%= bCount+bSubCount+cCount+cSubCount+mCount+mSubCount+tCount+tSubCount+pCount %>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr id="thHeader" style="background-color: bisque;">
                    <th style="width:40px;height:30px;padding: 0;text-align: center">#</th>
                    <%--<th style="width:12px;height:30px;padding: 0;">D</th>--%>
                    <th style="width:40px;height:30px;padding: 0;text-align: center;">ID</th>
                    <th style="width:40px;height:30px;padding: 0;text-align: center;">CD</th>
                    <th style="width:41px;height:30px;padding: 0;text-align: center;">股东</th>
                    <th style="width:41px;height:30px;padding: 0;text-align: center;">总代</th>
                    <%--<th style="width:38px;height:30px;padding: 0;text-align: right;">代理</th>--%>
                    <th style="width:172px;height:30px;padding: 0;text-align: center;">玩_PC_移动_安卓_IOS</th>
                    <th style="width:56px;height:30px;padding: 0;text-align: center;">&nbsp;IP游客</th>
                    <th style="width:177px;height:30px;padding: 0;text-align: center;">游_PC_移动_安卓_IOS</th>
                    <th style="width:60px;height:30px;padding: 0;text-align: center;">总在线</th>
                    <th style="width:110px;height:30px;0px 0px 0px 3px;text-align: center">Name</th>
                </tr>
                </thead>
                <tbody id="tbTbody" style="max-height: 400px;overflow-y: scroll;display: block;">
                <c:set var="index0" value="${0}"/>
                <c:forEach items="${sites}" var="p" varStatus="status">
                    <c:if test="${(p.status eq '1')}">
                        <tr style="background: #e4e2e2">
                            <c:set var="index0" value="${index0+1}"/>
                            <td style="width:40px;height:30px;padding: 0;text-align: center">${index0}</td>
                                <%--<td style="width:12px;height:30px;padding: 0;">${p.idc}</td>--%>
                            <td style="width:40px;height:30px;padding: 0;color: #8C1A00;text-align: center;">${p.id}</td>
                            <td style="width:40px;height:30px;padding: 0;text-align: center;">${p.code}</td>
                            <td style="width:41px;height:30px;padding: 0;text-align: center;" tag="${users[p.id]["mSite"]+users[p.id]["mSubSite"]}">
                                    ${users[p.id]["mSite"]}_${users[p.id]["mSubSite"]}</td>
                            <td style="width:41px;height:30px;padding: 0;text-align: center;" tag="${users[p.id]["tSite"]+users[p.id]["tSubSite"]}">
                                    ${users[p.id]["tSite"]}_${users[p.id]["tSubSite"]}</td>
                                <%--<td style="width:38px;height:30px;padding: 0;text-align: right;" tag="${users[p.id]["aSite"]+users[p.id]["aSubSite"]}">
                                        ${users[p.id]["aSite"]}_${users[p.id]["aSubSite"]}</td>--%>
                            <td style="width:172px;height:30px;padding: 0;text-align: center;" tag="${users[p.id]["pSite"]}">
                                <span style="width: 40px;text-align: center;color: red;font-weight: bold;">${users[p.id]["pSite"]}</span>_${users[p.id]["pSitePC"]}_${users[p.id]["pSiteH5"]}_${users[p.id]["pSiteAA"]}_${users[p.id]["pSiteAI"]}</td>
                            <td style="width:56px;height:30px;padding: 0;text-align: center;">
                                    ${users[p.id]["rGuest"]}</td>
                            <td style="width:177px;height:30px;padding: 0;text-align: center;" tag="${users[p.id]["pGuest"]}">
                                <span style="width:40px;text-align: center;color: red;font-weight: bold;">${users[p.id]["pGuest"]}</span>_${users[p.id]["pGuestPC"]}_${users[p.id]["pGuestH5"]}_${users[p.id]["pGuestAA"]}_${users[p.id]["pGuestAI"]}</td>
                            <td style="width:60px;height:30px;padding: 0;text-align: center;color: red;">
                                    ${users[p.id]["mSite"]+users[p.id]["mSubSite"]+
                                            users[p.id]["tSite"]+users[p.id]["tSubSite"]+
                                            users[p.id]["aSite"]+users[p.id]["aSubSite"]+
                                            users[p.id]["pSite"]}</td>
                            <td style="width:110px;height:30px;overflow: hidden;text-align: center">${p.name}</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </li>
    </ul>
</li>
<script>
    function showUsersUL() {
        if( $("#userOnlineUL").css("display")=="block") {
            $("#userOnlineUL").css("display", "none");
        }else{
            $("#userOnlineUL").css("display", "block");
        }
    }
    function sorTable() {
        $('#userOnlineTable #thHeader th').click(function(){
            var table = $("#userOnlineTable #tbTbody").eq(0);
            var rows = table.find('tr').toArray().sort(comparer($(this).index()));
            this.asc = !this.asc;
            if (!this.asc){rows = rows.reverse()}
            for (var i = 0; i < rows.length; i++){
                $($("td",rows[i])[0]).text(i+1);
                table.append(rows[i]);
            }
        })
    }
    /**
     * 比较
     * @param index
     * @returns {Function}
     */
    function comparer(index) {
        return function(a, b) {
            var valA = getCellValue(a, index), valB = getCellValue(b, index);
            return $.isNumeric(valA) && $.isNumeric(valB) ? valA - valB : valA.localeCompare(valB)
        }
    }
    /**
     * 取值
     * @param row
     * @param index
     * @returns {*|jQuery}
     */
    function getCellValue (row, index) {
        return $($(row).children('td').eq(index)).attr("tag")||$(row).children('td').eq(index).text();
    }
    sorTable();
</script>