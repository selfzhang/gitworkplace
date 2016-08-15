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

//K-means算法实现

public class KMeans { // 聚类的数目
	final static int ClassCount = 7;
	// 样本数目（测试集）
	static int InstanceNumber = 0;
	// 样本属性数目（测试）
	final static int FieldCount = 2;

	// 设置异常点阈值参数（每一类初始的最小数目为InstanceNumber/ClassCount^t）
	final static double t = 2.0;
	// 存放数据的矩阵
	private double[][] data;

	// 每个类的均值中心
	private double[][] classData;

	// 噪声集合索引
	private ArrayList<Integer> noises;

	// 存放每次变换结果的矩阵
	private ArrayList<ArrayList<Integer>> result;
	// 分隔符
	private static String split = " ";
	// 构造函数，初始化
	private static ArrayList<Point> points = new ArrayList<Point>();
	// 存储kmeans算法返回的结果集
	private static List<List<Point>> FinalresultList = new ArrayList<List<Point>>();

	private Utility utility = new Utility();

	public void init() {
		// 最后一位用来储存结果

		classData = new double[ClassCount][FieldCount];
		result = new ArrayList<ArrayList<Integer>>(ClassCount);
		noises = new ArrayList<Integer>();

	}

	/*
	 * 读取测试集的数据
	 * 
	 * @param trainingFileName 测试集文件名
	 */
	public void readData(String trainingFileName) {
		try {
			FileReader fr = new FileReader(trainingFileName);
			FileReader countfr = new FileReader(trainingFileName);
			BufferedReader br = new BufferedReader(fr);
			BufferedReader countBR = new BufferedReader(countfr);
			// 存放数据的临时变量
			String lineData = null;
			String[] splitData = null;
			int lineCount = 0;
			int line = 0;
			// 获得行数也就是数据量
			while (countBR.ready()) {
				countBR.readLine();
				lineCount++;
			}

			InstanceNumber = lineCount;
//			System.out.println("...." + InstanceNumber);
			data = new double[InstanceNumber][FieldCount + 1];
			// 按行读取
			while (br.ready()) {
				// 得到原始的字符串
				lineData = br.readLine();
				splitData = lineData.split(split);
				// 转化为数据
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
	 * 聚类过程，主要分为两步 1.循环找初始点 2.不断调整直到分类不再发生变化
	 */
	public void cluster() {
		// 数据归一化
		normalize();
		// 标记是否需要重新找初始点
		boolean needUpdataInitials = true;

		// 找初始点的迭代次数
		int times = 1;
		// 找初始点
		while (needUpdataInitials) {
			needUpdataInitials = false;
			result.clear();

			// 一次找初始点的尝试和根据初始点的分类
			findInitials();
			firstClassify();

			// 如果某个分类的数目小于特定的阈值，则认为这个分类中的所有样本都是噪声点
			// 需要重新找初始点
			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).size() < InstanceNumber
						/ Math.pow(ClassCount, t)) {
					needUpdataInitials = true;
					noises.addAll(result.get(i));
				}
			}
		}

		// 找到合适的初始点后
		// 不断的调整均值中心和分类，直到不再发生任何变化
		Adjust();
	}

	/*
	 * 对数据进行归一化 1.找每一个属性的最大值 2.对某个样本的每个属性除以其最大值
	 */
	public void normalize() {
		// 找最大值
		double[] max = new double[FieldCount];
		for (int i = 0; i < InstanceNumber; i++) {
			for (int j = 0; j < FieldCount; j++) {
				if (data[i][j] > max[j])
					max[j] = data[i][j];
			}
		}

		// 归一化
		for (int i = 0; i < InstanceNumber; i++) {
			for (int j = 0; j < FieldCount; j++) {
				data[i][j] = data[i][j] / max[j];

			}
		}
	}

	// 关于初始向量的一次找寻尝试
	public void findInitials() {
		// a,b为标志距离最远的两个向量的索引
		int i, j, a, b;
		i = j = a = b = 0;

		// 最远距离
		double maxDis = 0;

		// 已经找到的初始点个数
		int alreadyCls = 2;

		// 存放已经标记为初始点的向量索引
		ArrayList<Integer> initials = new ArrayList<Integer>();

		// 从两个开始
		for (; i < InstanceNumber; i++) {
			// 噪声点
			if (noises.contains(i))
				continue;
			j = i + 1;
			for (; j < InstanceNumber; j++) {
				// 噪声点
				if (noises.contains(j))
					continue;
				// 找出最大的距离并记录下来
				double newDis = utility.calDis(data[i], data[j]);
				if (maxDis < newDis) {
					a = i;
					b = j;
					maxDis = newDis;
				}
			}

		}

		// 将前两个初始点记录下来
		initials.add(a);
		initials.add(b);
		classData[0] = data[a];
		classData[1] = data[b];
//		System.out.println("4444 "+data[a][1]+"    "+b);
		// 在结果中新建存放某样本索引的对象，并把初始点添加进去
		ArrayList<Integer> resultOne = new ArrayList<Integer>();
		ArrayList<Integer> resultTwo = new ArrayList<Integer>();
		resultOne.add(a);
		resultTwo.add(b);
		result.add(resultOne);
		result.add(resultTwo);

		// 找到剩余的几个初始点
		while (alreadyCls < ClassCount) {
			i = j = 0;
			double maxMin = 0;
			int newClass = -1;

			// 找最小值中的最大值
			for (; i < InstanceNumber; i++) {
				double min = 0;
				double newMin = 0;
				// 找和已有类的最小值
				if (initials.contains(i))
					continue;
				// 噪声点去除
				if (noises.contains(i))
					continue;
				for (j = 0; j < alreadyCls; j++) {
					newMin = utility.calDis(data[i], classData[j]);
					if (min == 0 || newMin < min)
						min = newMin;
				}

				// 新最小距离较大
				if (min > maxMin) {
					maxMin = min;
					newClass = i;
				}
			}
			// 添加到均值集合和结果集合中
			// System.out.println("NewClass"+newClass);
			initials.add(newClass);
			classData[alreadyCls++] = data[newClass];
			ArrayList<Integer> rslt = new ArrayList<Integer>();
			rslt.add(newClass);
			result.add(rslt);
		}
	}

	// 第一次分类
	public void firstClassify() {
		// 根据初始向量分类
		for (int i = 0; i < InstanceNumber; i++) {
			double min = 0f;
			int clsId = -1;
			for (int j = 0; j < classData.length; j++) {
				// 欧式距离
				double newMin = utility.calDis(classData[j], data[i]);
				if (clsId == -1 || newMin < min) {
					clsId = j;
					min = newMin;
				}

			}
			// 本身不再添加
			if (!result.get(clsId).contains(i))
				result.get(clsId).add(i);
		}
	}

	// 迭代分类，直到各个类的数据不再变化
	public void Adjust() {
		// 记录是否发生变化
		boolean change = true;

		// 循环的次数
		// int times = 1;
		while (change) {
			// 复位
			change = false;
			// 重新计算每个类的均值
			for (int i = 0; i < ClassCount; i++) {
				// 原有的数据
				ArrayList<Integer> cls = result.get(i);

				// 新的均值
				double[] newMean = new double[FieldCount];

				// 计算均值
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
			// 清空之前的数据
			for (ArrayList<Integer> cls : result)
				cls.clear();

			// 重新分配
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
	 * 将结果输出到一个文件中
	 * 
	 * @param fileName
	 */
	public void printResult() {
		FileWriter fw = null;
		BufferedWriter bw = null;

		// 统计每类的数目，打印到控制台
		for (int i = 0; i < ClassCount; i++) {
			
			System.out.print("第" + (i + 1) + "类数: ");
			ArrayList<Point> TempPList = new ArrayList<Point>();
			
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + "  ");
				
				//对数据进行标记类号
				points.get(result.get(i).get(j)).setClusternum(i);
				
				TempPList.add(points.get(result.get(i).get(j)));
			}
			
			//将结果放入FinalresultList中，作为界面显示用
			FinalresultList.add(TempPList);
			System.out.println();
		}

	}

	/**
	 * 主函数入口 测试集的文件名称为“测试集.data”, 1.读取数据
	 * 
	 * 
	 * @param args
	 */
	public void main() {
		// TODO Auto-generated method stub

		// 初始化
		init();

		// 读取数据
		readData("E:\\kmeans2.txt");

		// 聚类过程
		cluster();

		// 输出结果
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