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
using System.Threading;

/*能力测试窗体*/

namespace danciben
{
    public partial class Form4 : Form
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
        public static string s;
        public static string beizhu;
        public static int Rnumber=0;
        public static int Wnumber = 0;
        public static int subnumber = 0;
        public static int id;
        public static int flag;
        public Form4()
        {
            InitializeComponent();
            Wnumber = 0;
            subnumber = 0;
            Rnumber = 0;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void return_bt_Click(object sender, EventArgs e)
        {
            this.Hide();
            Form1 f1 = new Form1();
            f1.Show();
        }

        private void down_bt_Click(object sender, EventArgs e)
        {

            if (this.Chinese_txt.Text.Trim() != "")
            {
                string strSql;
                try
                {
                    oleConn.Open();
                    if (flag % 2 == 0)
                    {// 偶数测试英译汉的能力
                        strSql = " Select ID,Chinese,lx from 单词库表 where english='" + this.textBox1.Text + "'";
                    }
                    else
                    {//奇数测试汉译英的能力
                        strSql = " Select ID,english,lx from 单词库表 where chinese='" + this.textBox1.Text + "'";
                    }
                    oleCmd = new OleDbCommand(strSql, oleConn);
                    OleDbDataReader or = oleCmd.ExecuteReader();
                    while (or.Read())
                    {
                        id =int.Parse( or[0].ToString());
                        s = or[1].ToString();
                        beizhu = or[2].ToString();
                    }
                    string s2 = this.Chinese_txt.Text.Trim();
                    int asic1 = ASCIIEncoding.ASCII.GetBytes(s2)[0];
                    int p=0;
                    if ( s2.Equals("的") || s2.Equals("地") || s2.Equals("得") || s2.Equals("在") || s2.Equals("再"))
                    {
                        p = 1;
                    }
                   
                    if (p!=1&&s.Contains(s2))
                    {
                        Rnumber++;
                        this.textBox4.Text = "答案是：" + s;
                        oleConn.Close();
                        Form4_Load(sender, e);
                    }
                    else
                    {
                        Wnumber++;
                        this.textBox4.Text = "上题答案是：" + s;
                        string sql = " Select english from 错题集 where ID=" + id + "";
                        oleCmd = new OleDbCommand(strSql, oleConn);
                        OleDbDataReader or1 = oleCmd.ExecuteReader();
                        while (or1.Read())
                        {

                        }
                        if (!or1.Read())
                        {
                            string strInsert;
                            try
                            {
                                System.DateTime time = new DateTime();
                                time = System.DateTime.Now;
                                int no = 1;
                                if (flag % 2 == 0)
                                {
                                    strInsert = @"insert into 错题集 (ID,english,Chinese,备注,时间,错误数)
                                   values (" + id + ",'" + this.textBox1.Text + "','" + s + "','" + beizhu + "','" + time + "','" + no + "')";
                                }
                                else
                                {
                                    strInsert = @"insert into 错题集 (ID,english,Chinese,备注,时间,错误数)
                                   values (" + id + ",'" + s + "','" + this.textBox1.Text + "','" + beizhu + "','" + time + "','" + no + "')";
                                }
                                oleCmd = new OleDbCommand(strInsert, oleConn);
                                oleCmd.ExecuteNonQuery();
                            }
                            catch (System.Data.OleDb.OleDbException err)
                            {
                                MessageBox.Show(err.Message + "dd");
                            }
                        }
                        else
                        {
                            try
                            {
                                System.DateTime time = new DateTime();
                                time = System.DateTime.Now;
                                string strMod = "update 错题集 set 错误数=错误数+1 where ID= " + id + "";
                                oleCmd = new OleDbCommand(strMod, oleConn);
                                oleCmd.ExecuteNonQuery();
                            }
                            catch (System.Data.OleDb.OleDbException err)
                            {
                                MessageBox.Show(err.Message + "保存失败");
                            }

                        }
                        oleConn.Close();
                        Form4_Load(sender, e);
                    }
                }
                catch (System.Data.OleDb.OleDbException err)
                {
                    MessageBox.Show(err.Message + "请与您的系统管理员联系!");
                }
            }
            else {
                MessageBox.Show("退出测试");
            }
        }

        private void Form4_Load(object sender, EventArgs e)
        {
            subnumber++;
            Random rand = new Random(); //产生随机数
            int temp = rand.Next() % 15000;
            flag = rand.Next() % 10; //产生随机数用来指定测试英语或中文
            string strSql;
            try
            {
                oleConn.Open();
                if (flag % 2 == 0)
                {// 偶数表示获得英文 
                    strSql = " Select english from 单词库表 where ID=" + temp + ""; //根据随机数获得单词
                }
                else
                {//奇数表示获得中文
                    strSql = " Select chinese from 单词库表 where ID=" + temp + "";
                }
                oleCmd = new OleDbCommand(strSql, oleConn);
                OleDbDataReader or = oleCmd.ExecuteReader();
                while (or.Read())
                {
                    this.textBox1.Text = or[0].ToString();
                }
                oleConn.Close();
                this.textBox2.Text = subnumber.ToString();
                this.textBox3.Text = Rnumber.ToString();
            }
            catch (System.Data.OleDb.OleDbException err)
            {
                MessageBox.Show(err.Message + "请与您的系统管理员联系!");
                oleConn.Close();
            }           
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
            Form8 f8 = new Form8();
            f8.Show();
        }
    }
}
