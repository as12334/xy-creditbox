package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.lang.DateTool;
import org.soul.commons.support.Nonpersistent;
import org.soul.model.common.Sortable;
import java.util.Date;


/**
 * 彩种盘口实体
 *
 * @author block
 * @time 2019-10-21 0:05:08
 */
//region your codes 1
public class LotteryHandicapBase implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -8958743901156707414L;
	//endregion your codes 3

	//endregion

	//region your codes 2

	//endregion your codes 2

	private static String format = "HH:mm:ss";

	public static void main(String[] args) throws InterruptedException {
		generaCqsscTime();
	}

	private static void generaCqsscTime() throws InterruptedException {
		//10点到第二天凌晨1点55
		int GMT = 8;
		int i = 1;
		String endTime = "";
		Date lotteryTime = null;
		Date startDate = null;

		while (true) {
//			if(i<=23){
//				if(i==1){
//					startTime = "00:00:00";
//					startDate = DateTool.parseDate(startTime, format);
//				}
//
//				Date closeTime = DateTool.addMinutes(startDate, 3);
//				Date lotteryTime = DateTool.addMinutes(startDate, 5);
//				startDate = generate(GMT, startDate, i, closeTime, lotteryTime);
//			}else if(23<i&&i<97){
//				if(i==24){
//					startTime = "09:50:00";
//					startDate = DateTool.parseDate(startTime, format);
//				}
//				Date closeTime = DateTool.addMinutes(startDate, 8);
//				Date lotteryTime = DateTool.addMinutes(startDate, 10);
//				startDate = generate(GMT, startDate, i, closeTime, lotteryTime);
//			}else if(97<=i&&i<=120){
//				if(i==97){
//					startTime = "22:00:00";
//					startDate = DateTool.parseDate(startTime, format);
//				}
//				Date closeTime = DateTool.addMinutes(startDate, 3);
//				Date lotteryTime = DateTool.addMinutes(startDate, 5);
//				startDate = generate(GMT, startDate, i, closeTime, lotteryTime);
//			}else {
//				return;
//			}
			if (i <= 60 * 24 / 3) {
				if (i == 1) {
					endTime = "00:00:00";
					lotteryTime = DateTool.parseDate(endTime, format);
				}

				Date closeTime = DateTool.addSeconds(lotteryTime, -10);
				startDate = DateTool.addSeconds(lotteryTime, -400);
				generate(GMT, startDate, i, closeTime, lotteryTime);
				lotteryTime = DateTool.addMinutes(lotteryTime, 5);
			} else {
				return;
			}
			i++;
		}


	}

	private static void generate(int GMT, Date startDate, int i, Date closeTime, Date lotteryTime) {
//		System.out.print("期号:"+ StringTool.leftPad(String.valueOf(i),3,"0"));
//		System.out.print("======");
//		System.out.print(DateTool.formatDate(startDate, DateTool.yyyy_MM_dd_HH_mm_ss));
//		System.out.print("======");
//		System.out.print(DateTool.formatDate(closeTime, DateTool.yyyy_MM_dd_HH_mm_ss));
//		System.out.print("======");
//		System.out.print(DateTool.formatDate(lotteryTime, DateTool.yyyy_MM_dd_HH_mm_ss));
//		System.out.print("==================");

		String opentime = DateTool.formatDate(DateTool.addHours(startDate, -GMT), format);
//		System.out.print(opentime);
//		System.out.print("======");
		String close = DateTool.formatDate(DateTool.addHours(closeTime, -GMT), format);
//		System.out.print(close);
//		System.out.print("======");
		String lottery = DateTool.formatDate(DateTool.addHours(lotteryTime, -GMT), format);
//		System.out.println(lottery);

		StringBuilder temple = new StringBuilder();
		temple.append(" INSERT into lottery_handicap (code,expect, open_time,close_time,lottery_time,id) select ");
		temple.append(" ''{0}'' ,");
		temple.append(" ''{1}'' ,");
		temple.append(" ''{2}'' ,");
		temple.append(" ''{3}'' ,");
		temple.append(" ''{4}'' ,");
		temple.append(" ''{5}'' where not EXISTS  (select  id from lottery_handicap where expect =''{1}'' and code=''{0}''); \r\n");
//		String sql = MessageFormat.format(temple.toString(), LotteryEnum.WFSSC.getCode(), StringTool.leftPad(String.valueOf(i), 3, "0"), opentime, close, lottery, String.valueOf(11000 + i).replace(",", ""));
//		System.out.println(sql);
	}


	private Integer expectCount;

	@Nonpersistent
	public Integer getExpectCount() {
		return expectCount;
	}

	public void setExpectCount(Integer expectCount) {
		this.expectCount = expectCount;
	}

	@Override
	public Integer getId() {
		return null;
	}

	@Override
	public void setId(Integer integer) {

	}
}