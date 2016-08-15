package kMeans;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.xml.transform.Templates;

import common.Point;
import drawCluster.DrawCluster;

//K-means�㷨ʵ��

public class KMeans { // �������Ŀ
	final static int ClassCount = 7;
	// ������Ŀ�����Լ���
	static int InstanceNumber = 0;
	// ����������Ŀ�����ԣ�
	final static int FieldCount = 2;

	// �����쳣����ֵ������ÿһ���ʼ����С��ĿΪInstanceNumber/ClassCount^t��
	final static double t = 2.0;
	// ������ݵľ���
	private double[][] data;

	// ÿ����ľ�ֵ����
	private double[][] classData;

	// ������������
	private ArrayList<Integer> noises;

	// ���ÿ�α任����ľ���
	private ArrayList<ArrayList<Integer>> result;
	// �ָ���
	private static String split = " ";
	// ���캯������ʼ��
	private static ArrayList<Point> points = new ArrayList<Point>();
	// �洢kmeans�㷨���صĽ����
	private static List<List<Point>> FinalresultList = new ArrayList<List<Point>>();

	private Utility utility = new Utility();

	public void init() {
		// ���һλ����������

		classData = new double[ClassCount][FieldCount];
		result = new ArrayList<ArrayList<Integer>>(ClassCount);
		noises = new ArrayList<Integer>();

	}

	/*
	 * ��ȡ���Լ�������
	 * 
	 * @param trainingFileName ���Լ��ļ���
	 */
	public void readData(String trainingFileName) {
		try {
			FileReader fr = new FileReader(trainingFileName);
			FileReader countfr = new FileReader(trainingFileName);
			BufferedReader br = new BufferedReader(fr);
			BufferedReader countBR = new BufferedReader(countfr);
			// ������ݵ���ʱ����
			String lineData = null;
			String[] splitData = null;
			int lineCount = 0;
			int line = 0;
			// �������Ҳ����������
			while (countBR.ready()) {
				countBR.readLine();
				lineCount++;
			}

			InstanceNumber = lineCount;
//			System.out.println("...." + InstanceNumber);
			data = new double[InstanceNumber][FieldCount + 1];
			// ���ж�ȡ
			while (br.ready()) {
				// �õ�ԭʼ���ַ���
				lineData = br.readLine();
				splitData = lineData.split(split);
				// ת��Ϊ����
				if (splitData.length > 1) {
					for (int i = 0; i < splitData.length; i++) {

						data[line][i] = Double.parseDouble(splitData[i]);

					}
					points.add(new Point(line,
							Double.parseDouble(splitData[0]), Double
									.parseDouble(splitData[1])));

					line++;
				}
			}

//			System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * ������̣���Ҫ��Ϊ���� 1.ѭ���ҳ�ʼ�� 2.���ϵ���ֱ�����಻�ٷ����仯
	 */
	public void cluster() {
		// ���ݹ�һ��
		normalize();
		// ����Ƿ���Ҫ�����ҳ�ʼ��
		boolean needUpdataInitials = true;

		// �ҳ�ʼ��ĵ�������
		int times = 1;
		// �ҳ�ʼ��
		while (needUpdataInitials) {
			needUpdataInitials = false;
			result.clear();

			// һ���ҳ�ʼ��ĳ��Ժ͸��ݳ�ʼ��ķ���
			findInitials();
			firstClassify();

			// ���ĳ���������ĿС���ض�����ֵ������Ϊ��������е�������������������
			// ��Ҫ�����ҳ�ʼ��
			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).size() < InstanceNumber
						/ Math.pow(ClassCount, t)) {
					needUpdataInitials = true;
					noises.addAll(result.get(i));
				}
			}
		}

		// �ҵ����ʵĳ�ʼ���
		// ���ϵĵ�����ֵ���ĺͷ��ֱ࣬�����ٷ����κα仯
		Adjust();
	}

	/*
	 * �����ݽ��й�һ�� 1.��ÿһ�����Ե����ֵ 2.��ĳ��������ÿ�����Գ��������ֵ
	 */
	public void normalize() {
		// �����ֵ
		double[] max = new double[FieldCount];
		for (int i = 0; i < InstanceNumber; i++) {
			for (int j = 0; j < FieldCount; j++) {
				if (data[i][j] > max[j])
					max[j] = data[i][j];
			}
		}

		// ��һ��
		for (int i = 0; i < InstanceNumber; i++) {
			for (int j = 0; j < FieldCount; j++) {
				data[i][j] = data[i][j] / max[j];

			}
		}
	}

	// ���ڳ�ʼ������һ����Ѱ����
	public void findInitials() {
		// a,bΪ��־������Զ����������������
		int i, j, a, b;
		i = j = a = b = 0;

		// ��Զ����
		double maxDis = 0;

		// �Ѿ��ҵ��ĳ�ʼ�����
		int alreadyCls = 2;

		// ����Ѿ����Ϊ��ʼ�����������
		ArrayList<Integer> initials = new ArrayList<Integer>();

		// ��������ʼ
		for (; i < InstanceNumber; i++) {
			// ������
			if (noises.contains(i))
				continue;
			j = i + 1;
			for (; j < InstanceNumber; j++) {
				// ������
				if (noises.contains(j))
					continue;
				// �ҳ����ľ��벢��¼����
				double newDis = utility.calDis(data[i], data[j]);
				if (maxDis < newDis) {
					a = i;
					b = j;
					maxDis = newDis;
				}
			}

		}

		// ��ǰ������ʼ���¼����
		initials.add(a);
		initials.add(b);
		classData[0] = data[a];
		classData[1] = data[b];
//		System.out.println("4444 "+data[a][1]+"    "+b);
		// �ڽ�����½����ĳ���������Ķ��󣬲��ѳ�ʼ����ӽ�ȥ
		ArrayList<Integer> resultOne = new ArrayList<Integer>();
		ArrayList<Integer> resultTwo = new ArrayList<Integer>();
		resultOne.add(a);
		resultTwo.add(b);
		result.add(resultOne);
		result.add(resultTwo);

		// �ҵ�ʣ��ļ�����ʼ��
		while (alreadyCls < ClassCount) {
			i = j = 0;
			double maxMin = 0;
			int newClass = -1;

			// ����Сֵ�е����ֵ
			for (; i < InstanceNumber; i++) {
				double min = 0;
				double newMin = 0;
				// �Һ����������Сֵ
				if (initials.contains(i))
					continue;
				// ������ȥ��
				if (noises.contains(i))
					continue;
				for (j = 0; j < alreadyCls; j++) {
					newMin = utility.calDis(data[i], classData[j]);
					if (min == 0 || newMin < min)
						min = newMin;
				}

				// ����С����ϴ�
				if (min > maxMin) {
					maxMin = min;
					newClass = i;
				}
			}
			// ��ӵ���ֵ���Ϻͽ��������
			// System.out.println("NewClass"+newClass);
			initials.add(newClass);
			classData[alreadyCls++] = data[newClass];
			ArrayList<Integer> rslt = new ArrayList<Integer>();
			rslt.add(newClass);
			result.add(rslt);
		}
	}

	// ��һ�η���
	public void firstClassify() {
		// ���ݳ�ʼ��������
		for (int i = 0; i < InstanceNumber; i++) {
			double min = 0f;
			int clsId = -1;
			for (int j = 0; j < classData.length; j++) {
				// ŷʽ����
				double newMin = utility.calDis(classData[j], data[i]);
				if (clsId == -1 || newMin < min) {
					clsId = j;
					min = newMin;
				}

			}
			// ���������
			if (!result.get(clsId).contains(i))
				result.get(clsId).add(i);
		}
	}

	// �������ֱ࣬������������ݲ��ٱ仯
	public void Adjust() {
		// ��¼�Ƿ����仯
		boolean change = true;

		// ѭ���Ĵ���
		// int times = 1;
		while (change) {
			// ��λ
			change = false;
			// ���¼���ÿ����ľ�ֵ
			for (int i = 0; i < ClassCount; i++) {
				// ԭ�е�����
				ArrayList<Integer> cls = result.get(i);

				// �µľ�ֵ
				double[] newMean = new double[FieldCount];

				// �����ֵ
				for (Integer index : cls) {
					for (int j = 0; j < FieldCount; j++)
						newMean[j] += data[index][j];
				}
				for (int j = 0; j < FieldCount; j++)
					newMean[j] /= cls.size();
				if (!utility.compareMean(newMean, classData[i])) {
					classData[i] = newMean;
					change = true;
				}
			}
			// ���֮ǰ������
			for (ArrayList<Integer> cls : result)
				cls.clear();

			// ���·���
			for (int i = 0; i < InstanceNumber; i++) {
				double min = 0f;
				int clsId = -1;
				for (int j = 0; j < classData.length; j++) {
					double newMin = utility.calDis(classData[j], data[i]);
					if (clsId == -1 || newMin < min) {
						clsId = j;
						min = newMin;
					}
				}
				data[i][FieldCount] = clsId;
				result.get(clsId).add(i);
			}
		}

	}

	/**
	 * ����������һ���ļ���
	 * 
	 * @param fileName
	 */
	public void printResult() {
		FileWriter fw = null;
		BufferedWriter bw = null;

		// ͳ��ÿ�����Ŀ����ӡ������̨
		for (int i = 0; i < ClassCount; i++) {
			
			System.out.print("��" + (i + 1) + "����: ");
			ArrayList<Point> TempPList = new ArrayList<Point>();
			
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + "  ");
				
				//�����ݽ��б�����
				points.get(result.get(i).get(j)).setClusternum(i);
				
				TempPList.add(points.get(result.get(i).get(j)));
			}
			
			//���������FinalresultList�У���Ϊ������ʾ��
			FinalresultList.add(TempPList);
			System.out.println();
		}

	}

	/**
	 * ��������� ���Լ����ļ�����Ϊ�����Լ�.data��, 1.��ȡ����
	 * 
	 * 
	 * @param args
	 */
	public void main() {
		// TODO Auto-generated method stub

		// ��ʼ��
		init();

		// ��ȡ����
		readData("E:\\kmeans2.txt");

		// �������
		cluster();

		// ������
		printResult();

		JFrame aFrame = new JFrame("K-Means");
		DrawCluster aa = new DrawCluster(FinalresultList);
		aFrame.setSize(700, 600);
		aFrame.setVisible(true);
		aFrame.add(aa);
		aFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

	}
}