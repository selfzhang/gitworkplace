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

/*错题集窗体 用来显示在能力测试中打错的单词*/

namespace danciben
{
    public partial class Form8 : Form
    {
        public static string strConn = @"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=db_myl.mdb";
        //oledb的连接
        public OleDbConnection oleConn = new OleDbConnection(strConn);
        //oledb的数据适配器
        public OleDbDataAdapter oleDa=new OleDbDataAdapter ();
        //oledb的命令运行
        public OleDbCommand oleCmd=new OleDbCommand ();
        //一个数据表 
        public DataTable dtStu;
        public DataSet ds = new DataSet();
        public OleDbCommandBuilder ocb=new OleDbCommandBuilder();
        public static int ID;
        public Form8()
        {
            InitializeComponent();
        }

        private void Form8_Load(object sender, EventArgs e)
        {
            try
            {
                string strSql = " Select ID,english,Chinese,错误数 from 错题集";
                oleCmd = new OleDbCommand(strSql,oleConn);
                oleDa = new OleDbDataAdapter(oleCmd);
                oleDa.Fill(ds, "单词库表");
                this.wrongword_View1.DataSource = ds.Tables["单词库表"];
                wrongword_View1.Columns[0].Visible = false;
                wrongword_View1.AllowUserToAddRows = false;
            }
            catch (System.Data.OleDb.OleDbException err)
            {
                MessageBox.Show(err.Message + "请与您的系统管理员联系!");
            }

        }

        private void close_Click(object sender, EventArgs e)
        {
            try
            {
                oleCmd = oleConn.CreateCommand();
                oleCmd.CommandText = "Select id ,english ,chinese,错误数 from 错题集";
                oleDa = new OleDbDataAdapter(oleCmd);
                ocb = new OleDbCommandBuilder(oleDa);
                oleDa.Update(ds.Tables[0]);
                MessageBox.Show("保存成功");
                this.wrongword_View1.Update();
            }
            catch (System.Data.OleDb.OleDbException err)
            {
                MessageBox.Show(err.Message + "请与您的系统管理员联系!");
            }
            this.Close();
            Form1 f1 = new Form1();
            f1.Show();
        }
        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

            if (this.wrongword_View1.SelectionMode != DataGridViewSelectionMode.FullColumnSelect)
            {
                int index = e.RowIndex;
                if (index >= 0 && (wrongword_View1.Rows[index].Cells[0].Value.ToString()!=null))//
                {
                   
                    ID = int.Parse(wrongword_View1.Rows[index].Cells[0].Value.ToString());
                    Form7 f7 = new Form7();
                    f7.Show();
                }
            }

        }
        private void button1_Click(object sender, EventArgs e)
        {
            Form4 f4 = new Form4();
            f4.Show();
            this.Close();
        }
    }
}
