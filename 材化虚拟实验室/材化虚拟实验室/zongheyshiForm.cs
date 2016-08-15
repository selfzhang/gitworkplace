using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 材化虚拟实验室
{
    public partial class zongheyshiForm : Form
    {
        public zongheyshiForm()
        {
            InitializeComponent();
        }

        private void zongheyshiForm_Load(object sender, EventArgs e)
        {
            Form2.JTPF.TopLevel = false;
            Form2.JTPF.Height = this.splitContainer3.Panel1.Height;
            Form2.JTPF.Width = this.splitContainer3.Panel1.Width;
            Form2.JTPF.Show();
            this.splitContainer3.Panel1.Controls.Add(Form2.JTPF);


        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
