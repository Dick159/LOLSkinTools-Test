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
 * äɮ ��ɭ---LeeSin ��Ͱ ������˹---Gragas ��սʿ ������---Olaf ������ ������ ��Ĺ�� Լ���---Yorick ̽�ռ�
 * ������� ĺ��֮�� ��---Shen �޼���ʥ ��---MasterYi ����Ů�� ��----lulu �籩֮ŭ ����----Janna ����֮��
 * ����----Riven ��β���� ����----Ahri ��ϫ���� ����----Fizz �������� ��ϣ----ashe ������ʹ
 * ����----judicator �°��ܹ� ����----XenZhao ��֮�� ����----Kennen �ڰ�֮Ů ����----annie ���˷�ʦ
 * ����---Ryze ������ʿ ����---Sion Ѹ�ݳ�� ��Ī---Teemo ѩ����ʿ ŬŬ---Yeti ����֮Դ ͼ��---twitch ��ħС��
 * ����---Jester ��ɪ��Ů ���---Sona ����֮Ӱ ̩¡---Talon �籩֮ŭ ���� �������� ħ�� Ť������ ï��---Maokai
 * ��ҹ���� ޱ��---Vayne ��е���� ����---Rumble ������ʹ ����---poppy ս��֮�� ��ɭ---Pantheon ���ƹ���
 * ����˹---Ziggs �ݶ�֮ŭ ɪׯ��---sejuani �����ʥ �����---MonkeyKing ��е���� ά����---Viktor ˮ���ȷ�
 * ˹����---Skarner ����ǹ�� ���׷�---Graves ����ҹ�� ŵ�˶�---Nocturne ������� ������---Brand Ұ��֮��
 * �ڵ϶�---Udyr ɳĮ���� ��ɪ˹---Nasus ����֮�� ���ʿ�---Pirate ��ʯ��ʿ �����---GemKnight ��ʿͳ��
 * ˹ά��---Swain ��˫���� �ư���---fiora ������� ������---���İ��Voidwalker���İ�ǰ��Kassadin Զ������
 * ����˹---Xerath ��Ѫ���� �����---olfman Ƥ��Ů�� ������----caitlyn ��տ־� �Ƽ�˹----Green Terror
 * ��Ԩ�޿� �˸�\'Ī----KogMaw ���Ů�� ����˿----Lux �������� ��Ī˹----Armordillo ��������
 * ��ܽ��----LeBlanc ��Į���� �׿˶�----Renekton ��Ӱ֮ȭ ������----akali �ڱ�֮�� �����---Galio ���ƴ�ʦ
 * ��˹��----Cardmaster ����֮�� �����---- ս��Ů�� ϣά��---Sivir ����֮�� ������---Soraka ������ʦ
 * �ֿ�˹---jax ������ʹ Ī����---FallenAngel ������ʿ ������---Singed ���Ҿ��� ī����---Malphite ��Ѫ�伧
 * ϣ����---Shyvana �̩̹ ŵ����˹---Nautilus �����ͽ ���׸�˹---Graves ����ŭ�� ��������---Volibear
 * ����ħ�� ������ �����ħ ���ʵ¶�---Trundle ����֮�� ��������---Katarina ţͷ���� ����˹�� ĩ��ʹ��
 * �ѵ����---FiddleSticks �������� ��˿����---Tristana �ͽ����� ����С��---MissFortune ����֮��
 * ̩���׶�---DarkChampion ������� ����ά��---Cryophoenix �氲���� �ɶ�ҽ�� ������־ �������---Irelia ��еľż
 * ������ ������ ��Ĭ����---heimerTurret ������ʦ Ī�¿���---Mordekaiser �����֪ �������---Malzahar
 * ����MalzaharVoidling��Al_Voidling_TX_CM.dds ħ��֮ӵ ���������---Cassiopeia Ӣ��Ͷ����
 * ����---Corki ʱ���ػ��� ����---Zilean а��С��ʦ ά��---Veigar ��ҰŮ���� �ε���---Nidalee ��֮ľ����
 * ��ľľ---Amumu �Ѹ������� ��ܽ��---Evelynn ���������� �����---SteamGolem �����̳��� ������˹---Lich
 * �ɺ��ո��� �������׶�---vladimir ��������֮�� ���� �������ǻ��� ��������---JarvanIV ��֮׷���� �׶��Ӷ�---Rengar
 */
