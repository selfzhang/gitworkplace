using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

/*进行游戏设置*/

namespace danciben
{
    public partial class Form9 : Form
    {
        public static int no=3;//猜测次数初始化为3
        public static int percent = 2;//提示单词字母个数初始化为2
        public Form9()
        {
            InitializeComponent();
        }

        private void Form9_Load(object sender, EventArgs e)
        {
            this.textBox1.Text = no.ToString();
            this.textBox2.Text = percent.ToString();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            no = int.Parse(this.textBox1.Text.Trim());
            percent = int.Parse(this.textBox2.Text.Trim());
            this.Close();
            Form1 f1 = new Form1();
            f1.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            no = int.Parse(this.textBox1.Text.Trim());
            percent = int.Parse(this.textBox2.Text.Trim());
            this.Close();
            Form5 f5 = new Form5();
            f5.Show();
        }
    }
}
