package Day190715;

public class Ex4 {
	final static int RECODE_NUM = 10; //������ ���ڵ��� ���� ���Ѵ�.
	final static String TABLE_NAME = "TEST_TABLE";
	final static String[] CODE1 = {"010", "011", "017", "018", "019"};
	final static String[] CODE2 = {"����", "����"};
	final static String[] CODE3 = {"10��", "20��", "30��", "40��", "50��"};
	
	public static String getRandArr(String[] arr) {
		return arr[getRand(arr.length-1)];//�迭�� ����� �� �� �ϳ��� ��ȯ�Ѵ�. arr[getRand(4)]
	}
	public static int getRand(int n) {
		return getRand(0,n);//getRand(0,4)
	}
	public static int getRand(int from, int to) {//Math.random()*5 (0~4)
		//Math.random() * 101 + 100 (100~200)
		return (int)(Math.random()*(Math.abs(to-from)+1)) + Math.min(from, to);
	}

	public static void main(String[] args) {
		for(int i = 0; i < RECODE_NUM; i++) {
			System.out.println("INSERT INTO " + TABLE_NAME
					+" VALUES ("
					+ " " + getRandArr(CODE1)+ "'"
					+ "," + getRandArr(CODE2) + "'"
					+ "," + getRandArr(CODE3) + "'"
					+ "," + getRand(100,200) //100~200������ ���� ��´�.
					+ ");");
		}

	}

}
