using System;
using System.Data;
using System.Windows.Forms;
using System.Data.OleDb;

/* 计划修改窗体*/

namespace danciben
{
    public partial class Form3 : Form
    {
        public static string plan;
        public static int number;
        public static string strConn = @"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=db_myl.mdb";
        //oledb的连接
        public OleDbConnection oleConn = new OleDbConnection(strConn);
        //oledb的数据适配器
        public OleDbDataAdapter oleDa = new OleDbDataAdapter();
        //oledb的命令运行
        public OleDbCommand oleCmd = new OleDbCommand();
        //一个数据表 
        public DataTable dtStu;
        public DataSet ds = new DataSet();
        public OleDbCommandBuilder ocb = new OleDbCommandBuilder();
        public Form3()
        {
            InitializeComponent();
        }
        private void Form3_Load(object sender, EventArgs e)
        {
            textBox1.Text = Form6.plan;
            this.textBox2.Text = Form6.number.ToString();
        }
        private void button1_Click(object sender, EventArgs e)
        {//修改计划
            try
            {
                oleConn = new OleDbConnection(strConn);
                oleConn.Open();
                System.DateTime time = new DateTime();
                time = System.DateTime.Now;
                string strMod = "update 计划表 set 新增计划 = '" + this.textBox1.Text + "',重要度=" + int.Parse(this.textBox2.Text) + " where 编号= " + Form6.bh + "";
             
                oleCmd = new OleDbCommand(strMod, oleConn);
                oleCmd.ExecuteNonQuery();
                MessageBox.Show("保存成功");
                this.Close();
                Form6 f6 = new Form6();
                f6.Show();
            }
            catch (System.Data.OleDb.OleDbException err)
            {
                MessageBox.Show(err.Message+"保存失败");
                Form3_Load(sender, e);
                this.Close();
            }
        }

        private void delete_Click(object sender, EventArgs e)
        {
            //删除计划
            try
            {
                oleConn = new OleDbConnection(strConn);
                oleConn.Open();
                string strMod = "delete * from 计划表 where 编号=" + Form6.bh + "";
                oleCmd = new OleDbCommand(strMod, oleConn);
                oleCmd.ExecuteNonQuery();
                MessageBox.Show("删除成功");
                this.Close();
                Form6 f6 = new Form6();
                f6.Show();
            }
            catch (System.Data.OleDb.OleDbException err)
            {
                MessageBox.Show("保存失败");
                Form3_Load(sender, e);
                this.Hide();
            }
        }
    }
}
