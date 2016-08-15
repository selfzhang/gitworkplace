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

/*单词详解*/

namespace danciben
{
    public partial class Form7 : Form
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
        public Form7()
        {
            InitializeComponent();
        }

        private void Form7_Load(object sender, EventArgs e)
        {//获得错题集中单词的详细信息
            try
            {
                oleConn = new OleDbConnection(strConn);
                oleConn.Open();
                string strSql = " Select english,Chinese,lx from 单词库表 where ID="+Form8.ID+"";
                oleCmd = new OleDbCommand(strSql, oleConn);
                OleDbDataReader or = oleCmd.ExecuteReader();
               
               while (or.Read())
                {
                    this.textBox1.Text = or[0].ToString();
                    this.textBox3.Text = or[1].ToString();
                    this.textBox2.Text = or[2].ToString();
                }
                
            }
            catch (System.Data.OleDb.OleDbException err)
            {
                MessageBox.Show(err.Message + "请与您的系统管理员联系!");
            }
        }
       
    }
}
