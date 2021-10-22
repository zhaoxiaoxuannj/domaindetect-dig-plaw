package zxx.datd.test;	/*
	 * 版权： 
	 * 描述：
	 * 修改人： zhaoxx
	 * 修改时间：2021-08-01
	 * 修改内容：新增
	 */

import java.util.Arrays;
import java.util.List;

public class InputStr {
	public  static String tunnelTestStr="192.168.249.139|pafycowa.dns.datd.work.|20211011155709|192.168.249.2|\n" +
			"192.168.249.139|pafycowi.dns.datd.work.|20211011155711|192.168.249.2|\n" +
			"192.168.249.139|1ehaxpdnggyhambygkyfqtf4nxaobqhw33hiuaydgmidgpqzydzos0ib4d3yzq.bqadu55bldgibqgeylbm.dns.datd.work.|20211011155711|192.168.249.2|\n" +
			"192.168.249.139|1ehaypdnggyhambygkyfqtf4nxaobqhw33hiuaydgmidgpqzydzos0ib4d3yzq.bqadu55bldgibqgeylbm.dns.datd.work.|20211011155712|192.168.249.2|\n" +
			"192.168.249.139|1epbze2lcmdvo0m02pbca2kgmzthmaalgodx5.dns.datd.work.|20211011155713|192.168.249.2|\n" +
			"192.168.249.139|1epb0e2lcmdvo0m02pbca2kgmzthmaalgodx5.dns.datd.work.|20211011155714|192.168.249.2|\n" +
			"192.168.249.139|paeacowq.dns.datd.work.|20211011155715|192.168.249.2|\n" +
			"192.168.249.139|1iaa1pdnggyhambygkyfqtf4mpaobqhw331iuaydgmidgpqzydzos0ib4d3yzq.bqadu55rk5ykdamjqwcy.dns.datd.work.|20211011155715|192.168.249.2|\n" +
			"192.168.249.139|1iaa2pdnggyhambygkyfqtf4mpaobqhw331iuaydgmidgpqzydzos0ib4d3yzq.bqadu55rk5ykdamjqwcy.dns.datd.work.|20211011155716|192.168.249.2|\n" +
			"192.168.249.139|1iaa3pdnggyhambygkyfqtf4mpaobqhw331iuaydgmidgpqzydzos0ib4d3yzq.bqadu55rk5ykdamjqwcy.dns.datd.work.|20211011155717|192.168.249.2|\n" +
			"192.168.249.139|1iid4jyweyhc2u3vu2mmdyqmztgozaexpad54.dns.datd.work.|20211011155717|192.168.249.2|\n" +
			"192.168.249.139|1iid5jyweyhc2u3vu2mmdyqmztgozaexpad54.dns.datd.work.|20211011155719|192.168.249.2|\n" +
			"192.168.249.139|paeicowy.dns.datd.work.|20211011155719|192.168.249.2|\n" +
			"192.168.249.139|1mba6pdnggyhambygkybqtf4m5aobqhw33qyuaydgmidgpqzydzos0ib4cd4ua.rh001qqmd4h4mqifdemr.dns.datd.work.|20211011155719|192.168.249.2|\n" +
			"192.168.249.139|1mba7pdnggyhambygkybqtf4m5aobqhw33qyuaydgmidgpqzydzos0ib4cd4ua.rh001qqmd4h4mqifdemr.dns.datd.work.|20211011155720|192.168.249.2|\n" +
			"192.168.249.139|1mjd8yf01vzq4143gxk03adiyaeyd.dns.datd.work.|20211011155721|192.168.249.2|\n" +
			"192.168.249.139|1mjd9yf01vzq4143gxk03adiyaeyd.dns.datd.work.|20211011155722|192.168.249.2|\n" +
			"192.168.249.139|1mjdayf01vzq4143gxk03adiyaeyd.dns.datd.work.|20211011155723|192.168.249.2|\n" +
			"192.168.249.139|paeqcoxa.dns.datd.work.|20211011155723|192.168.249.2|\n" +
			"192.168.249.139|paeqcoxi.dns.datd.work.|20211011155724|192.168.249.2|\n" +
			"192.168.249.139|paeqcoxq.dns.datd.work.|20211011155725|192.168.249.2|\n" +
			"192.168.249.139|1qccbpdnggyhambygkybqth4nbaobqhw33piuaydgmidgpqzydzos0ibzdtdkq.ktvmnyigd5f5yigcrsoj.dns.datd.work.|20211011155725|192.168.249.2|\n" +
			"192.168.249.139|1qcccpdnggyhambygkybqth4nbaobqhw33piuaydgmidgpqzydzos0ibzdtdkq.ktvmnyigd5f5yigcrsoj.dns.datd.work.|20211011155726|192.168.249.2|\n" +
			"192.168.249.139|1qccdpdnggyhambygkybqth4nbaobqhw33piuaydgmidgpqzydzos0ibzdtdkq.ktvmnyigd5f5yigcrsoj.dns.datd.work.|20211011155727|192.168.249.2|\n" +
			"192.168.249.139|1qlbe2a3f125x5o3gxk03ac5lieyd.dns.datd.work.|20211011155727|192.168.249.2|\n" +
			"192.168.249.139|1qlbf2a3f125x5o3gxk03ac5lieyd.dns.datd.work.|20211011155728|192.168.249.2|\n" +
			"192.168.249.139|1qlbg2a3f125x5o3gxk03ac5lieyd.dns.datd.work.|20211011155729|192.168.249.2|\n" +
			"192.168.249.139|1udchpdnggyhambygkybqth4mraobqhw33xiuaydgmidgpqzydzos0ibzdtdkq.ktvmnyigd5j5yiccrsoj.dns.datd.work.|20211011155729|192.168.249.2|\n" +
			"192.168.249.139|1udcipdnggyhambygkybqth4mraobqhw33xiuaydgmidgpqzydzos0ibzdtdkq.ktvmnyigd5j5yiccrsoj.dns.datd.work.|20211011155730|192.168.249.2|\n" +
			"192.168.249.139|1uldj2a3f1s51opo1lvjoac2a0eqe.dns.datd.work.|20211011155731|192.168.249.2|\n" +
			"192.168.249.139|1uldk2a3f1s51opo1lvjoac2a0eqe.dns.datd.work.|20211011155732|192.168.249.2|\n" +
			"192.168.249.139|1uldl2a3f1s51opo1lvjoac2a0eqe.dns.datd.work.|20211011155733|192.168.249.2|\n" +
			"192.168.249.139|paeysoxy.dns.datd.work.|20211011155733|192.168.249.2|\n" +
			"192.168.249.139|paeysoya.dns.datd.work.|20211011155735|192.168.249.2|\n" +
			"192.168.249.139|paeysoyi.dns.datd.work.|20211011155737|192.168.249.2|\n" +
			"192.168.249.139|paeysoyq.dns.datd.work.|20211011155738|192.168.249.2|\n" +
			"192.168.249.139|paeysoyy.dns.datd.work.|20211011155740|192.168.249.2|\n" +
			"192.168.249.139|paeysoza.dns.datd.work.|20211011155742|192.168.249.2|\n" +
			"192.168.249.139|paeysozi.dns.datd.work.|20211011155743|192.168.249.2|\n" +
			"192.168.249.139|paeysozq.dns.datd.work.|20211011155745|192.168.249.2|\n" +
			"192.168.249.139|paeysozy.dns.datd.work.|20211011155746|192.168.249.2|\n" +
			"192.168.249.139|paeyso0a.dns.datd.work.|20211011155748|192.168.249.2|\n" +
			"192.168.249.139|paeyso0i.dns.datd.work.|20211011155749|192.168.249.2|\n" +
			"192.168.249.139|paeyso0q.dns.datd.work.|20211011155751|192.168.249.2|\n" +
			"192.168.249.139|paeyso0y.dns.datd.work.|20211011155752|192.168.249.2|\n" +
			"192.168.249.139|1ydcmpdnggyhambygkyamt54mjaobqhw43dquaydgmidgpqzydzos0ib4cd4ua.rh001uqmd4p5lylfdemr.dns.datd.work.|20211011155752|192.168.249.2|\n" +
			"192.168.249.139|1ydcnpdnggyhambygkyamt54mjaobqhw43dquaydgmidgpqzydzos0ib4cd4ua.rh001uqmd4p5lylfdemr.dns.datd.work.|20211011155754|192.168.249.2|\n" +
			"192.168.249.139|1ylcoyf01ununppo1lvjoz5tky2kmj5gsw4nsxp02tpwzj5ls243sopa5gbktt.0x3z3tem515gkjl11x4s.dns.datd.work.|20211011155754|192.168.249.2|\n" +
			"192.168.249.139|1ylcpyf01ununppo1lvjoz5tky2kmj5gsw4nsxp02tpwzj5ls243sopa5gbktt.0x3z3tem515gkjl11x4s.dns.datd.work.|20211011155755|192.168.249.2|\n" +
			"192.168.249.139|1ytcqpgyx344t314ub3utlv4u5j3whxmtcc4ip1mtbzp3tzdc2zb4kdoyxrrjz.21453skfvesuswmzqvx3.dns.datd.work.|20211011155756|192.168.249.2|\n" +
			"192.168.249.139|1ytcrpgyx344t314ub3utlv4u5j3whxmtcc4ip1mtbzp3tzdc2zb4kdoyxrrjz.21453skfvesuswmzqvx3.dns.datd.work.|20211011155757|192.168.249.2|\n" +
			"192.168.249.139|1ytcspgyx344t314ub3utlv4u5j3whxmtcc4ip1mtbzp3tzdc2zb4kdoyxrrjz.21453skfvesuswmzqvx3.dns.datd.work.|20211011155758|192.168.249.2|\n" +
			"192.168.249.139|1y1ctwfs41e23dopk0xp2xszqgywqwmu4xh5vgtbeigvzxcpc2010g0trh1ees.5j3ppk2gqbwuylh35jx0.dns.datd.work.|20211011155758|192.168.249.2|\n" +
			"192.168.249.139|1y1cuwfs41e23dopk0xp2xszqgywqwmu4xh5vgtbeigvzxcpc2010g0trh1ees.5j3ppk2gqbwuylh35jx0.dns.datd.work.|20211011155800|192.168.249.2|\n" +
			"192.168.249.139|1zdcvbufbsjjfaxcvn4x0kumzsonjpkm5scsp5n3v4lxlpdonbrgfawzg3xmsu.5ww0cszgd3xie0b2yudz.dns.datd.work.|20211011155800|192.168.249.2|\n" +
			"192.168.249.139|1zdcwbufbsjjfaxcvn4x0kumzsonjpkm5scsp5n3v4lxlpdonbrgfawzg3xmsu.5ww0cszgd3xie0b2yudz.dns.datd.work.|20211011155801|192.168.249.2|\n" +
			"192.168.249.139|1zlcx1hi5blft5pm4ylopuzwxrp1hc03cd4sga0dbn4qgc13inzx0bcwttgojv.f22lkn0ywuukznjiw3ms.dns.datd.work.|20211011155802|192.168.249.2|\n" +
			"192.168.249.139|1zlcy1hi5blft5pm4ylopuzwxrp1hc03cd4sga0dbn4qgc13inzx0bcwttgojv.f22lkn0ywuukznjiw3ms.dns.datd.work.|20211011155804|192.168.249.2|\n" +
			"192.168.249.139|1ztdziwe2twl0des1sok2aacjznj2.dns.datd.work.|20211011155805|192.168.249.2|\n" +
			"192.168.249.139|1ztd0iwe2twl0des1sok2aacjznj2.dns.datd.work.|20211011155806|192.168.249.2|\n" +
			"192.168.249.139|pafaco1a.dns.datd.work.|20211011155807|192.168.249.2|\n" +
			"192.168.249.139|pafaco1i.dns.datd.work.|20211011155808|192.168.249.2|\n" +
			"192.168.249.139|pafaco1q.dns.datd.work.|20211011155808|192.168.249.2|\n" +
			"192.168.249.139|pafaso1y.dns.datd.work.|20211011155809|192.168.249.2|\n" +
			"192.168.249.139|pafaso2a.dns.datd.work.|20211011155810|192.168.249.2|\n" +
			"192.168.249.139|pafaso2i.dns.datd.work.|20211011155811|192.168.249.2|\n" +
			"192.168.249.139|pafaso2q.dns.datd.work.|20211011155812|192.168.249.2|";

	public static List<String> getTunneldata(){
		String aftermsg=tunnelTestStr.replace("192.168.249.2|","81");
		List<String> resultList=Arrays.asList(aftermsg.split("\n"));;
		return resultList;
	}
}
