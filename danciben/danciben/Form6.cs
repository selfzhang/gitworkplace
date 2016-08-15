using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.OleDb;

/*计划查询窗体*/

namespace danciben
{

    public partial class Form6 : Form
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
        public static DateTime time;
        public static int bh;
        public Form6()
        {
            InitializeComponent();
        }

        private void return_bt_Click(object sender, EventArgs e)
        {
            this.Hide();
            Form1 f1 = new Form1();
            f1.Show();
        }

        private void Form6_Load(object sender, EventArgs e)
        {//显示当前计划
            try
            {
                oleConn = new OleDbConnection(strConn);
                oleConn.Open();
                string strSql = " Select 编号, 重要度, 新增计划,时间 from 计划表";
                dtStu = new DataTable();
                oleDa = new OleDbDataAdapter(strSql, oleConn);
                oleDa.Fill(dtStu);

                this.dataGridView1.DataSource = dtStu;
                dataGridView1.Columns[0].Visible = false;

                dataGridView1.AllowUserToAddRows = false;
            }
            catch (System.Data.OleDb.OleDbException err)
            {
                MessageBox.Show(err.Message + "请与您的系统管理员联系!");
            }
        }
        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

            if (this.dataGridView1.SelectionMode != DataGridViewSelectionMode.FullColumnSelect)
            {

                int index = e.RowIndex;
                if (index >= 0)
                {

                    bh = int.Parse(dataGridView1.Rows[index].Cells[0].Value.ToString());
                    number = int.Parse(dataGridView1.Rows[index].Cells[1].Value.ToString());
                    plan = dataGridView1.Rows[index].Cells[2].Value.ToString();
                    time = Convert.ToDateTime(dataGridView1.Rows[index].Cells[3].Value.ToString());
                    this.Close();
                    Form3 f3 = new Form3();
                    f3.Show();
                }
            }

        }
        private void down_bt_Click(object sender, EventArgs e)
        {//新建复习计划
            try
            {
                int no = int.Parse(this.no_txt.Text.Trim());
                string plan = this.plan_box.Text.Trim();
                System.DateTime time = new DateTime();
                time = System.DateTime.Now;
                string strInsert = @"insert into 计划表 (重要度,新增计划,时间) values ('" + no + "','" + plan + "','" + time + "')";
                oleCmd = new OleDbCommand(strInsert, oleConn);
                oleCmd.ExecuteNonQuery();
            }
            catch (System.Data.OleDb.OleDbException err)
            {
                MessageBox.Show("重新填写");
            }
            MessageBox.Show("保存成功");
            Form6_Load(sender, e);
            this.Show();
        }
    }
}
