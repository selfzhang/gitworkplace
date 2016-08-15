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

/*翻译窗体*/

namespace danciben
{
    public partial class Form2 : Form
    {
        public static string strConn = @"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=db_myl.mdb";
        //oledb的连接
        public OleDbConnection oleConn;
        //oledb的数据适配器
        public OleDbDataAdapter oleDa;
        //oledb的命令运行
        public OleDbCommand oleCmd;
        //一个数据表 
        public DataTable dtStu;
        public Form2()
        {
            InitializeComponent();
        }
        
        private void english_text_TextChanged(object sender, EventArgs e)
        {

        }

        private void return_bt_Click(object sender, EventArgs e)
        {
            this.Hide();
            Form1 f1 = new Form1();
            f1.Show();
        }

        private void fanyi_E_C_Click(object sender, EventArgs e)
        {//翻译
            string s = this.english_text.Text.Trim() ;
            if (checkBox1.Checked && !checkBox2.Checked)
            {//英译汉
                try
                {
                    oleConn = new OleDbConnection(strConn);
                    oleConn.Open();
                    string strSql = " Select english,Chinese,lx from 单词库表 where English='" + s + "'";
                    oleCmd = new OleDbCommand(strSql, oleConn);
                    OleDbDataReader or = oleCmd.ExecuteReader();
                    dtStu = new DataTable();
                    oleDa = new OleDbDataAdapter(strSql, oleConn);
                    oleDa.Fill(dtStu);
                    this.dataGridView1.DataSource = dtStu;
                    dataGridView1.Columns[1].Visible = false;
                    if (or.Read())
                    {

                        this.textBox1.Text = or[1].ToString();
                    }
                    else {

                        MessageBox.Show("没有此单词");
                    }
                }
                catch (System.Data.OleDb.OleDbException err)
                {
                    MessageBox.Show(err.Message + "请与您的系统管理员联系!");
                }
            } 
            else if (checkBox2.Checked && !checkBox1.Checked)
                {//汉译英                  
                    try
                    {
                        oleConn = new OleDbConnection(strConn);
                        oleConn.Open();
                        string strSql = " Select english,chinese,lx from 单词库表 where chinese LIKE '%"+s+"%'";
                        oleCmd = new OleDbCommand(strSql, oleConn);
                        OleDbDataReader or = oleCmd.ExecuteReader();
                        dtStu = new DataTable();
                        oleDa = new OleDbDataAdapter(strSql, oleConn);
                        oleDa.Fill(dtStu);
                        this.dataGridView1.DataSource = dtStu;
                        dataGridView1.Columns[2].Visible = false;
                        dataGridView1.Columns[1].Visible = false;
                       
                        while (or.Read())
                        {
                            this.textBox1.Text = or[1].ToString();
                        }
                    }
                    catch (System.Data.OleDb.OleDbException err)
                    {
                        MessageBox.Show(err.Message + "请与您的系统管理员联系!");
                    }
                }
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }
        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {//获得点击的位置

            if (this.dataGridView1.SelectionMode != DataGridViewSelectionMode.FullColumnSelect)
            {//显示单击位置的单词的详尽信息

                int index = e.RowIndex;
                if (index >= 0)
                {
                    this.textBox2.Text = dataGridView1.Rows[index].Cells[1].Value.ToString();
                    this.textBox1.Text = dataGridView1.Rows[index].Cells[2].Value.ToString();      
                }
            }

        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox1.Checked)
            {
                checkBox1.Checked = true;
                checkBox2.Checked = false;
            }
        }

        private void checkBox2_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox2.Checked)
            {
                checkBox2.Checked = true;
                checkBox1.Checked = false;
            }
        }
    }
  
}
