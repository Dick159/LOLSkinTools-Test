package common;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import Util.FileUtil;

public class CharacterConstant {

	public static Map<String, String> keyMap = new HashMap<String, String>();

	public static Map<String, String> valueMap = new HashMap<String, String>();

	static {
		makeMap();
	}

	private static void makeMap() {
		File file = new File( Path.DDS_FILE_BASE_PATH );
		File[] files = file.listFiles();
		for( File f : files ) {
			String fileName = f.getName();
			String suffix = FileUtil.getSuffix( fileName );
			if( suffix.equals( "zip" ) ) {
				String value = FileUtil.getPrefix( fileName );
				String key = FileUtil.getMaxEn( fileName );
				keyMap.put( key, value );
				valueMap.put( value, key );
			}
		}
	}

}

/*
 * 盲僧 李森---LeeSin 酒桶 古拉加斯---Gragas 狂战士 奥拉夫---Olaf 天启者 卡尔玛 掘墓者 约里克---Yorick 探险家
 * 伊泽瑞尔 暮光之眼 慎---Shen 无极剑圣 易---MasterYi 仙灵女巫 璐璐----lulu 风暴之怒 迦娜----Janna 放逐之刃
 * 锐雯----Riven 九尾妖狐 阿狸----Ahri 潮汐海灵 菲兹----Fizz 寒冰射手 艾希----ashe 审判天使
 * 凯尔----judicator 德邦总管 赵信----XenZhao 狂暴之心 凯南----Kennen 黑暗之女 安妮----annie 流浪法师
 * 瑞兹---Ryze 亡灵勇士 赛恩---Sion 迅捷斥候 提莫---Teemo 雪人骑士 努努---Yeti 瘟疫之源 图奇---twitch 恶魔小丑
 * 萨科---Jester 琴瑟仙女 娑娜---Sona 刀锋之影 泰隆---Talon 风暴之怒 迦娜 永恒梦魇 魔腾 扭曲树精 茂凯---Maokai
 * 暗夜猎手 薇恩---Vayne 机械公敌 兰博---Rumble 钢铁大使 波比---poppy 战争之王 潘森---Pantheon 爆破鬼才
 * 吉格斯---Ziggs 凛冬之怒 瑟庄妮---sejuani 齐天大圣 孙悟空---MonkeyKing 机械先驱 维克托---Viktor 水晶先锋
 * 斯卡纳---Skarner 亡命枪匪 格雷夫---Graves 永恒夜魇 诺克顿---Nocturne 复仇焰魂 布兰德---Brand 野兽之灵
 * 乌迪尔---Udyr 沙漠死神 内瑟斯---Nasus 海洋之灾 普朗克---Pirate 宝石骑士 塔里克---GemKnight 策士统领
 * 斯维因---Swain 无双剑姬 菲奥娜---fiora 虚空行者 卡萨丁---（改版后）Voidwalker（改版前）Kassadin 远古巫灵
 * 泽拉斯---Xerath 嗜血猎手 沃里克---olfman 皮城女警 凯特琳----caitlyn 虚空恐惧 科加斯----Green Terror
 * 深渊巨口 克格\'莫----KogMaw 光辉女郎 拉克丝----Lux 披甲龙龟 拉莫斯----Armordillo 诡术妖姬
 * 乐芙兰----LeBlanc 荒漠屠夫 雷克顿----Renekton 暗影之拳 阿卡丽----akali 哨兵之殇 加里奥---Galio 卡牌大师
 * 崔斯特----Cardmaster 首领之傲 厄加特---- 战争女神 希维尔---Sivir 众星之子 索拉卡---Soraka 武器大师
 * 贾克斯---jax 堕落天使 莫甘娜---FallenAngel 炼金术士 辛吉德---Singed 熔岩巨兽 墨菲特---Malphite 龙血武姬
 * 希瓦娜---Shyvana 深海泰坦 诺提勒斯---Nautilus 法外狂徒 格雷福斯---Graves 雷鸣怒吼 沃利贝尔---Volibear
 * 发条魔灵 奥莉安娜 诅咒巨魔 特朗德尔---Trundle 不祥之刃 卡特琳娜---Katarina 牛头酋长 阿利斯塔 末日使者
 * 费德提克---FiddleSticks 麦林炮手 崔丝塔娜---Tristana 赏金猎人 厄运小姐---MissFortune 蛮族之王
 * 泰达米尔---DarkChampion 冰晶凤凰 艾尼维亚---Cryophoenix 祖安狂人 蒙多医生 刀锋意志 艾瑞莉娅---Irelia 机械木偶
 * 奥莉安娜 大发明家 黑默丁格---heimerTurret 金属大师 莫德凯撒---Mordekaiser 虚空先知 玛尔扎哈---Malzahar
 * 附：MalzaharVoidling→Al_Voidling_TX_CM.dds 魔蛇之拥 卡西奥佩娅---Cassiopeia 英勇投弹手
 * 库奇---Corki 时光守护者 基兰---Zilean 邪恶小法师 维迦---Veigar 狂野女猎手 奈德丽---Nidalee 殇之木乃伊
 * 阿木木---Amumu 寡妇制造者 伊芙琳---Evelynn 蒸汽机器人 布里茨---SteamGolem 死亡颂唱者 卡尔萨斯---Lich
 * 猩红收割者 弗拉基米尔---vladimir 德玛西亚之力 盖伦 德玛西亚皇子 嘉文四世---JarvanIV 傲之追猎者 雷恩加尔---Rengar
 */
