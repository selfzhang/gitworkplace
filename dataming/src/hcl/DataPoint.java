package hcl;


public class DataPoint {
	int dataPointName; // ��������
	Cluster cluster; // �������������
	private double dimensioin[]; // �������ά��

	public DataPoint() {
	}

	public DataPoint(double[] dimensioin, int line) {
		this.dataPointName = line;
		this.dimensioin = dimensioin;
	}

	public double[] getDimensioin() {
		return dimensioin;
	}

	public void setDimensioin(double[] dimensioin) {
		this.dimensioin = dimensioin;
	}

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public int getDataPointName() {
		return dataPointName;
	}

	public void setDataPointName(int dataPointName) {
		this.dataPointName = dataPointName;
	}
}
