using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.OleDb;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 材化虚拟实验室
{
    public partial class gongJianForm : Form
    {
        public static string strConn = @"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=db_myl.mdb";
        //oledb的连接
        public OleDbConnection oleConn;
        //oledb的数据适配器
        public OleDbDataAdapter oleDa;
        //oledb的命令运行
        public OleDbCommand oleCmd;
        //一个数据表 
        public DataTable gongjiantable;
        public gongJianForm()
        {
            InitializeComponent();
        }

        private void gongJianForm_Load(object sender, EventArgs e)
        {
            try
            {
                oleConn = new OleDbConnection(strConn);
                oleConn.Open();
                string strSql = " Select 零件名称 from 零件库 ";
                oleCmd = new OleDbCommand(strSql, oleConn);
                OleDbDataReader or = oleCmd.ExecuteReader();
                gongjiantable = new DataTable();
                oleDa = new OleDbDataAdapter(strSql, oleConn);
                oleDa.Fill(gongjiantable);
                this.dataGridView1.DataSource = gongjiantable;

            }
            catch (System.Data.OleDb.OleDbException err)
            {
                MessageBox.Show(err.Message + "请与您的系统管理员联系!");
            }
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            //获得点击的位置
            SchemeDesign sdf = new SchemeDesign();
            if (this.dataGridView1.SelectionMode != DataGridViewSelectionMode.FullColumnSelect)
            {
                int index = e.RowIndex;
                if (index >= 0)
                {
                    SchemeDesign.lingjian = dataGridView1.Rows[index].Cells[0].Value.ToString();
                    ControlForm.lingjian = dataGridView1.Rows[index].Cells[0].Value.ToString();
                    
                    Form2.sdF.lingjianSet();
                }
            }
        }
    }
}
