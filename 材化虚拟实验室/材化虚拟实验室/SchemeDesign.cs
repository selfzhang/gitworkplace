using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Microsoft.Office.Interop.Word;
using System.IO;

namespace 材化虚拟实验室
{
    public partial class SchemeDesign : Form
    {
        public SchemeDesign()
        {
            InitializeComponent();
        }
        public static string tuzhihao;
        public static string cailiao;
        public static string lingjian;
        public static string gongyi;
        private void SchemeDesign_Load(object sender, EventArgs e)
        {
            
        }
        public void tuzhiset() {
            this.tuzhi_tx.Text = tuzhihao;
        }
        public void cailiaoSet() {
            this.cailiao_tx.Text = cailiao;
        }
        public void lingjianSet() {
            this.lingjian_tx.Text = lingjian;
        }
        public void gongyiSet() {
            gongyi = this.gongyi_tx.Text;
        }
     public void CreateWordFile( )
        {
            string message = "";
            try
            {
                Object Nothing = System.Reflection.Missing.Value;
                Directory.CreateDirectory("C:/热处理实验");  //创建文件所在目录
                string name = gongyiren_tx.Text +"__"+ DateTime.Now.ToLongDateString() + ".doc";//文件名
                object filename = "C://热处理实验//" + name;  //文件保存路径
                //创建Word文档
                Microsoft.Office.Interop.Word.Application WordApp = new Microsoft.Office.Interop.Word.Application();
                Microsoft.Office.Interop.Word.Document WordDoc = WordApp.Documents.Add(ref Nothing, ref Nothing, ref Nothing, ref Nothing);
                //文档中创建表格
                Microsoft.Office.Interop.Word.Table newTable = WordDoc.Tables.Add(WordApp.Selection.Range, 7, 3, ref Nothing, ref Nothing);
                //设置表格样式
                newTable.Borders.OutsideLineStyle = Microsoft.Office.Interop.Word.WdLineStyle.wdLineStyleThickThinLargeGap;
                newTable.Borders.InsideLineStyle =Microsoft.Office.Interop.Word.WdLineStyle.wdLineStyleSingle;
                newTable.Columns[1].Width = 150f;
                newTable.Columns[2].Width =150f;
                newTable.Columns[3].Width = 150f;
                // 合并单元格
                newTable.Cell(1, 1).Merge(newTable.Cell(1, 3));
                newTable.Cell(4, 2).Merge(newTable.Cell(7, 2));
                newTable.Cell(6, 3).Merge(newTable.Cell(7, 3));
                WordApp.Selection.Cells.VerticalAlignment = Microsoft.Office.Interop.Word.WdCellVerticalAlignment.wdCellAlignVerticalCenter;//垂直居中

                //填充表格内容
                newTable.Cell(1, 1).Range.Text = "工艺卡片";
                newTable.Cell(1, 1).Range.Bold = 2;//设置单元格中字体为粗体
                newTable.Cell(1, 1).Range.ParagraphFormat.Alignment = Microsoft.Office.Interop.Word.WdParagraphAlignment.wdAlignParagraphCenter; ;//设置单元格中字体为粗体
                //填充表格内容
                newTable.Cell(2, 1).Range.Text = "零件名称："+lingjian_tx.Text;
                newTable.Cell(3, 1).Range.Text = "图纸号：" + tuzhi_tx.Text;
                newTable.Cell(4, 1).Range.Text = "热工艺处理名称："+gongyi_tx.Text;
                gongyiSet();
                newTable.Cell(5, 1).Range.Text = "工艺制定人："+gongyiren_tx.Text;
                newTable.Cell(6, 1).Range.Text = "工艺审核人："+shenheren_tx.Text;
                newTable.Cell(7, 1).Range.Text = "工艺批准人："+pizhunren_tx.Text;
                newTable.Cell(2, 2).Range.Text = "材料："+cailiao_tx.Text;
                newTable.Cell(3, 2).Range.Text = "件数："+jianshu_tx.Text;
                newTable.Cell(4, 2).Range.Text = "性能要求：" + xingneng_tx.Text;
                newTable.Cell(2, 3).Range.Text = "装炉温度：" + luwen_tx.Text;
                newTable.Cell(3, 3).Range.Text = "升温速度：" + shengwen_tx.Text;
                newTable.Cell(4, 3).Range.Text = "保温时间：" + baowen_tx.Text;
                newTable.Cell(5, 3).Range.Text = "冷却方式：" + comboBox1.Text;
                newTable.Cell(6, 3).Range.Text = "备注：" + beizhu_tx.Text;
                //在表格中增加行
                WordDoc.Content.Tables[1].Rows.Add(ref Nothing);
                WordDoc.Paragraphs.Last.Range.Text = "文档创建时间：" + DateTime.Now.ToString();//“落款”
                WordDoc.Paragraphs.Last.Alignment = Microsoft.Office.Interop.Word.WdParagraphAlignment.wdAlignParagraphRight;
                //文件保存
                 WordDoc.SaveAs(ref filename, ref Nothing, ref Nothing, ref Nothing, ref Nothing, ref Nothing, ref Nothing, ref Nothing, ref Nothing, ref Nothing, ref Nothing, ref Nothing, ref Nothing, ref Nothing, ref Nothing, ref Nothing);
                 WordDoc.Close(ref Nothing, ref Nothing, ref Nothing);
                 WordApp.Quit(ref Nothing, ref Nothing, ref Nothing);
                 message = name + "文档生成成功，保存到C:热处理实验文件夹下";
                 MessageBox.Show(message);
            }
            catch(Exception e)
            {               
                MessageBox.Show(e.Message);
            }
            
        }

     private void toolStripButton2_Click(object sender, EventArgs e)
     {
         CreateWordFile();
        
        
     }

     private void toolStripButton1_Click(object sender, EventArgs e)
     {
         lingjian_tx.Text = null;
          tuzhi_tx.Text = null;
          gongyi_tx.Text = null;
          gongyiren_tx.Text = null;
          shenheren_tx.Text = null;
          pizhunren_tx.Text = null;
          cailiao_tx.Text = null;
          jianshu_tx.Text = null;
          xingneng_tx.Text = null;
          luwen_tx.Text = null;
          shengwen_tx.Text = null;
          baowen_tx.Text = null;
          comboBox1.Text = null;
          beizhu_tx.Text = null;
     }

     private void gongyi_tx_SelectedIndexChanged(object sender, EventArgs e)
     {
         ControlForm.gongyi = this.gongyi_tx.SelectedItem.ToString();
         
     }

     private void lingjian_tx_MouseClick(object sender, MouseEventArgs e)
     {
         Form1.f2.gF.TopLevel = false;
         Form1.f2.gF.Height = this.splitContainer1.Panel2.Height;
         Form1.f2.gF.Location = new Point(0, 0);
         Form2.sdF.WindowState = FormWindowState.Normal;
         Form1.f2.splitContainer1.Panel2.Controls.Add(Form1.f2.gF);
         Form1.f2.gF.Hide();
         Form1.f2.gF.Show();
        
     }

     private void cailiao_tx_MouseClick(object sender, MouseEventArgs e)
     {
         Form1.f2.mF.TopLevel = false;
         Form1.f2.mF.Height = this.splitContainer1.Panel2.Height;
         Form1.f2.mF.Location = new Point(0, 0);
         Form2.sdF.WindowState = FormWindowState.Normal;
         Form1.f2.splitContainer1.Panel2.Controls.Add(Form1.f2.mF);
         Form1.f2.mF.Hide();
         Form1.f2.mF.Show();
     }

     private void tuzhi_tx_MouseClick(object sender, MouseEventArgs e)
     {
         Form1.f2.tzF.TopLevel = false;
         
         Form1.f2.tzF.Height = this.splitContainer1.Panel2.Height;
         Form1.f2.tzF.Location = new Point(0, 1);
         Form2.sdF.WindowState = FormWindowState.Normal;
         Form1.f2.splitContainer1.Panel2.Controls.Add(Form1.f2.tzF);
         Form1.f2.tzF.Hide();
         Form1.f2.tzF.Show();
     }
   }
    

}
