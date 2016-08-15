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

/*游戏窗体*/

namespace danciben
{
    public partial class Form5 : Form
    {
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
        public static string word;
        public static string chinese;
        public static int score=0;
        public static int no;
        public Form5()
        {
            InitializeComponent();
        }

        private void Form5_Load(object sender, EventArgs e)
        {
            no = Form9.no;
            Random rand = new Random();
            int temp = rand.Next() % 15000;
            string strSql;
            try
            {
                oleConn.Open();
                strSql = " Select english ,chinese from 单词库表 where ID=" + temp + "";
                oleCmd = new OleDbCommand(strSql, oleConn);
                OleDbDataReader or = oleCmd.ExecuteReader();
                while (or.Read())
                {
                    word = or[0].ToString();
                    chinese=or[1].ToString();
                   
                }
                oleConn.Close();
                //获得某些位置上的字母 其他的输入 然后整合判断

                if (Form9.percent <= word.Length)
                {//判断提示字母数是否大于单词总长度；大于则将整个单词显示；否则显示Form9.percent 个字母
                    this.textBox1.Text = "前" + Form9.percent.ToString() + "个字母为：" + word.Substring(0, Form9.percent);//获得单词的前percent个字母
                }
                else
                {
                    Form9.percent = word.Length;
                    this.textBox1.Text = "前" + Form9.percent.ToString() + "个字母为：" + word.Substring(0, Form9.percent);//获得单词的前percent个字母
                }
                this.textBox2.Text = "提示:\r\n"+"意思：" + chinese+"\r\n单词字母个数为:"+word.Length.ToString()+"\r\n";
                this.textBox4.Text = "共有" + Form9.no + "次机会";
                this.textBox3.Text = "根据提示写出完整的单词";
            }
            catch (System.Data.OleDb.OleDbException err)
            {
                MessageBox.Show(err.Message + "请与您的系统管理员联系!");
                oleConn.Close();
            }
        }

        private void return_bt_Click(object sender, EventArgs e)
        {
            this.Hide();
            Form1 f1 = new Form1();
            f1.Show();
        }

        private void button1_Click(object sender, EventArgs e)
        {
           //判断是否答题正确
           if (no >=0)
            {//猜测次数
                if (this.textBox3.Text.Trim().Equals(word))
                {
                    this.textBox4.Text = "答对了！";
                }
                else
                {
                    no--;
                    if (no > 0)
                    {
                        this.textBox4.Text = "还有" +no + "机会";
                    }
                    if (no == 0)
                    {
                        this.textBox4.Text = "很遗憾！";
                    }
                   
                }
                if (no == 0)
                {
                    this.textBox3.Text = "正确答案是："+word;
                }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
            Form9 f9 = new Form9();
            f9.Show();
            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Form5_Load(sender, e);
        }
    }
}
