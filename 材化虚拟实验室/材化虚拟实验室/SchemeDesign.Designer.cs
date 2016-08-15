using System.Windows.Forms;
namespace 材化虚拟实验室
{
    partial class SchemeDesign
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
           /* if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);*/
     /*       DialogResult tig=MessageBox.Show("是否保存？", "提示", MessageBoxButtons.YesNoCancel);
            if (tig == DialogResult.Yes)
            {
                this.Hide();
            }
            else if (tig == DialogResult.Cancel) { 
            
}
            else
            {
                this.Hide();
            }*/
          
            
            this.Hide();
           
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.splitContainer1 = new System.Windows.Forms.SplitContainer();
            this.gongyi_tx = new System.Windows.Forms.ComboBox();
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.toolStripButton2 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton1 = new System.Windows.Forms.ToolStripButton();
            this.tuzhi_tx = new System.Windows.Forms.TextBox();
            this.pizhunren_tx = new System.Windows.Forms.TextBox();
            this.shenheren_tx = new System.Windows.Forms.TextBox();
            this.gongyiren_tx = new System.Windows.Forms.TextBox();
            this.lingjian_tx = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.splitContainer2 = new System.Windows.Forms.SplitContainer();
            this.jianshu_tx = new System.Windows.Forms.TextBox();
            this.cailiao_tx = new System.Windows.Forms.TextBox();
            this.xingneng_tx = new System.Windows.Forms.TextBox();
            this.label9 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label15 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.baowen_tx = new System.Windows.Forms.TextBox();
            this.shengwen_tx = new System.Windows.Forms.TextBox();
            this.luwen_tx = new System.Windows.Forms.TextBox();
            this.beizhu_tx = new System.Windows.Forms.TextBox();
            this.label14 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).BeginInit();
            this.splitContainer1.Panel1.SuspendLayout();
            this.splitContainer1.Panel2.SuspendLayout();
            this.splitContainer1.SuspendLayout();
            this.toolStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer2)).BeginInit();
            this.splitContainer2.Panel1.SuspendLayout();
            this.splitContainer2.Panel2.SuspendLayout();
            this.splitContainer2.SuspendLayout();
            this.SuspendLayout();
            // 
            // splitContainer1
            // 
            this.splitContainer1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.splitContainer1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer1.Location = new System.Drawing.Point(0, 0);
            this.splitContainer1.Name = "splitContainer1";
            // 
            // splitContainer1.Panel1
            // 
            this.splitContainer1.Panel1.Controls.Add(this.gongyi_tx);
            this.splitContainer1.Panel1.Controls.Add(this.toolStrip1);
            this.splitContainer1.Panel1.Controls.Add(this.tuzhi_tx);
            this.splitContainer1.Panel1.Controls.Add(this.pizhunren_tx);
            this.splitContainer1.Panel1.Controls.Add(this.shenheren_tx);
            this.splitContainer1.Panel1.Controls.Add(this.gongyiren_tx);
            this.splitContainer1.Panel1.Controls.Add(this.lingjian_tx);
            this.splitContainer1.Panel1.Controls.Add(this.label8);
            this.splitContainer1.Panel1.Controls.Add(this.label5);
            this.splitContainer1.Panel1.Controls.Add(this.label4);
            this.splitContainer1.Panel1.Controls.Add(this.label3);
            this.splitContainer1.Panel1.Controls.Add(this.label2);
            this.splitContainer1.Panel1.Controls.Add(this.label1);
            // 
            // splitContainer1.Panel2
            // 
            this.splitContainer1.Panel2.Controls.Add(this.splitContainer2);
            this.splitContainer1.Size = new System.Drawing.Size(912, 582);
            this.splitContainer1.SplitterDistance = 294;
            this.splitContainer1.TabIndex = 0;
            // 
            // gongyi_tx
            // 
            this.gongyi_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.gongyi_tx.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.gongyi_tx.FormattingEnabled = true;
            this.gongyi_tx.Items.AddRange(new object[] {
            "淬火",
            "退火",
            "淬火退火"});
            this.gongyi_tx.Location = new System.Drawing.Point(14, 226);
            this.gongyi_tx.Name = "gongyi_tx";
            this.gongyi_tx.Size = new System.Drawing.Size(234, 22);
            this.gongyi_tx.TabIndex = 15;
            this.gongyi_tx.SelectedIndexChanged += new System.EventHandler(this.gongyi_tx_SelectedIndexChanged);
            // 
            // toolStrip1
            // 
            this.toolStrip1.BackColor = System.Drawing.SystemColors.Control;
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripButton2,
            this.toolStripButton1});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(290, 25);
            this.toolStrip1.TabIndex = 14;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // toolStripButton2
            // 
            this.toolStripButton2.Image = global::材化虚拟实验室.Properties.Resources.保存1;
            this.toolStripButton2.ImageAlign = System.Drawing.ContentAlignment.TopCenter;
            this.toolStripButton2.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton2.Name = "toolStripButton2";
            this.toolStripButton2.Size = new System.Drawing.Size(52, 22);
            this.toolStripButton2.Text = "保存";
            this.toolStripButton2.Click += new System.EventHandler(this.toolStripButton2_Click);
            // 
            // toolStripButton1
            // 
            this.toolStripButton1.Image = global::材化虚拟实验室.Properties.Resources.编辑;
            this.toolStripButton1.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton1.Name = "toolStripButton1";
            this.toolStripButton1.Size = new System.Drawing.Size(52, 22);
            this.toolStripButton1.Text = "新建";
            this.toolStripButton1.Click += new System.EventHandler(this.toolStripButton1_Click);
            // 
            // tuzhi_tx
            // 
            this.tuzhi_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.tuzhi_tx.Location = new System.Drawing.Point(14, 157);
            this.tuzhi_tx.Multiline = true;
            this.tuzhi_tx.Name = "tuzhi_tx";
            this.tuzhi_tx.Size = new System.Drawing.Size(234, 27);
            this.tuzhi_tx.TabIndex = 12;
            this.tuzhi_tx.MouseClick += new System.Windows.Forms.MouseEventHandler(this.tuzhi_tx_MouseClick);
            // 
            // pizhunren_tx
            // 
            this.pizhunren_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.pizhunren_tx.Location = new System.Drawing.Point(14, 434);
            this.pizhunren_tx.Multiline = true;
            this.pizhunren_tx.Name = "pizhunren_tx";
            this.pizhunren_tx.Size = new System.Drawing.Size(234, 27);
            this.pizhunren_tx.TabIndex = 13;
            // 
            // shenheren_tx
            // 
            this.shenheren_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.shenheren_tx.Location = new System.Drawing.Point(14, 376);
            this.shenheren_tx.Multiline = true;
            this.shenheren_tx.Name = "shenheren_tx";
            this.shenheren_tx.Size = new System.Drawing.Size(234, 27);
            this.shenheren_tx.TabIndex = 12;
            // 
            // gongyiren_tx
            // 
            this.gongyiren_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.gongyiren_tx.Location = new System.Drawing.Point(14, 299);
            this.gongyiren_tx.Multiline = true;
            this.gongyiren_tx.Name = "gongyiren_tx";
            this.gongyiren_tx.Size = new System.Drawing.Size(234, 27);
            this.gongyiren_tx.TabIndex = 11;
            // 
            // lingjian_tx
            // 
            this.lingjian_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.lingjian_tx.Location = new System.Drawing.Point(14, 95);
            this.lingjian_tx.Multiline = true;
            this.lingjian_tx.Name = "lingjian_tx";
            this.lingjian_tx.Size = new System.Drawing.Size(234, 27);
            this.lingjian_tx.TabIndex = 5;
            this.lingjian_tx.MouseClick += new System.Windows.Forms.MouseEventHandler(this.lingjian_tx_MouseClick);
            // 
            // label8
            // 
            this.label8.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(12, 133);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(41, 12);
            this.label8.TabIndex = 3;
            this.label8.Text = "图纸号";
            // 
            // label5
            // 
            this.label5.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(12, 409);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(65, 12);
            this.label5.TabIndex = 4;
            this.label5.Text = "工艺批准人";
            // 
            // label4
            // 
            this.label4.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(12, 343);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(65, 12);
            this.label4.TabIndex = 3;
            this.label4.Text = "工艺审核人";
            // 
            // label3
            // 
            this.label3.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 272);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(65, 12);
            this.label3.TabIndex = 2;
            this.label3.Text = "工艺制定人";
            // 
            // label2
            // 
            this.label2.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 200);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(89, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "热处理工艺名称";
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 72);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "零件名称";
            // 
            // splitContainer2
            // 
            this.splitContainer2.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.splitContainer2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer2.Location = new System.Drawing.Point(0, 0);
            this.splitContainer2.Name = "splitContainer2";
            // 
            // splitContainer2.Panel1
            // 
            this.splitContainer2.Panel1.Controls.Add(this.jianshu_tx);
            this.splitContainer2.Panel1.Controls.Add(this.cailiao_tx);
            this.splitContainer2.Panel1.Controls.Add(this.xingneng_tx);
            this.splitContainer2.Panel1.Controls.Add(this.label9);
            this.splitContainer2.Panel1.Controls.Add(this.label7);
            this.splitContainer2.Panel1.Controls.Add(this.label15);
            this.splitContainer2.Panel1.Controls.Add(this.label6);
            // 
            // splitContainer2.Panel2
            // 
            this.splitContainer2.Panel2.Controls.Add(this.comboBox1);
            this.splitContainer2.Panel2.Controls.Add(this.baowen_tx);
            this.splitContainer2.Panel2.Controls.Add(this.shengwen_tx);
            this.splitContainer2.Panel2.Controls.Add(this.luwen_tx);
            this.splitContainer2.Panel2.Controls.Add(this.beizhu_tx);
            this.splitContainer2.Panel2.Controls.Add(this.label14);
            this.splitContainer2.Panel2.Controls.Add(this.label13);
            this.splitContainer2.Panel2.Controls.Add(this.label12);
            this.splitContainer2.Panel2.Controls.Add(this.label11);
            this.splitContainer2.Panel2.Controls.Add(this.label10);
            this.splitContainer2.Size = new System.Drawing.Size(614, 582);
            this.splitContainer2.SplitterDistance = 293;
            this.splitContainer2.TabIndex = 0;
            // 
            // jianshu_tx
            // 
            this.jianshu_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.jianshu_tx.Location = new System.Drawing.Point(20, 170);
            this.jianshu_tx.Multiline = true;
            this.jianshu_tx.Name = "jianshu_tx";
            this.jianshu_tx.Size = new System.Drawing.Size(234, 27);
            this.jianshu_tx.TabIndex = 11;
            // 
            // cailiao_tx
            // 
            this.cailiao_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.cailiao_tx.Location = new System.Drawing.Point(20, 95);
            this.cailiao_tx.Multiline = true;
            this.cailiao_tx.Name = "cailiao_tx";
            this.cailiao_tx.Size = new System.Drawing.Size(234, 27);
            this.cailiao_tx.TabIndex = 10;
            this.cailiao_tx.MouseClick += new System.Windows.Forms.MouseEventHandler(this.cailiao_tx_MouseClick);
            // 
            // xingneng_tx
            // 
            this.xingneng_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.xingneng_tx.Location = new System.Drawing.Point(20, 299);
            this.xingneng_tx.Multiline = true;
            this.xingneng_tx.Name = "xingneng_tx";
            this.xingneng_tx.Size = new System.Drawing.Size(245, 250);
            this.xingneng_tx.TabIndex = 9;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(18, 226);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(53, 12);
            this.label9.TabIndex = 4;
            this.label9.Text = "性能要求";
            // 
            // label7
            // 
            this.label7.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(18, 131);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(29, 12);
            this.label7.TabIndex = 2;
            this.label7.Text = "件数";
            // 
            // label15
            // 
            this.label15.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.label15.AutoSize = true;
            this.label15.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label15.Location = new System.Drawing.Point(112, 13);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(67, 14);
            this.label15.TabIndex = 6;
            this.label15.Text = "工艺卡片";
            // 
            // label6
            // 
            this.label6.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(18, 70);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(29, 12);
            this.label6.TabIndex = 1;
            this.label6.Text = "材料";
            // 
            // comboBox1
            // 
            this.comboBox1.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.comboBox1.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Items.AddRange(new object[] {
            "炉冷",
            "空冷",
            "水冷",
            "油冷"});
            this.comboBox1.Location = new System.Drawing.Point(25, 304);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(234, 22);
            this.comboBox1.TabIndex = 12;
            // 
            // baowen_tx
            // 
            this.baowen_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.baowen_tx.Location = new System.Drawing.Point(25, 237);
            this.baowen_tx.Multiline = true;
            this.baowen_tx.Name = "baowen_tx";
            this.baowen_tx.Size = new System.Drawing.Size(234, 27);
            this.baowen_tx.TabIndex = 14;
            // 
            // shengwen_tx
            // 
            this.shengwen_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.shengwen_tx.Location = new System.Drawing.Point(25, 157);
            this.shengwen_tx.Multiline = true;
            this.shengwen_tx.Name = "shengwen_tx";
            this.shengwen_tx.Size = new System.Drawing.Size(234, 27);
            this.shengwen_tx.TabIndex = 13;
            // 
            // luwen_tx
            // 
            this.luwen_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.luwen_tx.Location = new System.Drawing.Point(25, 95);
            this.luwen_tx.Multiline = true;
            this.luwen_tx.Name = "luwen_tx";
            this.luwen_tx.Size = new System.Drawing.Size(234, 27);
            this.luwen_tx.TabIndex = 12;
            // 
            // beizhu_tx
            // 
            this.beizhu_tx.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.beizhu_tx.Location = new System.Drawing.Point(25, 376);
            this.beizhu_tx.Multiline = true;
            this.beizhu_tx.Name = "beizhu_tx";
            this.beizhu_tx.Size = new System.Drawing.Size(234, 173);
            this.beizhu_tx.TabIndex = 11;
            // 
            // label14
            // 
            this.label14.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label14.AutoSize = true;
            this.label14.Location = new System.Drawing.Point(23, 354);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(29, 12);
            this.label14.TabIndex = 5;
            this.label14.Text = "备注";
            // 
            // label13
            // 
            this.label13.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(23, 283);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(53, 12);
            this.label13.TabIndex = 4;
            this.label13.Text = "冷却方式";
            // 
            // label12
            // 
            this.label12.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(23, 200);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(53, 12);
            this.label12.TabIndex = 3;
            this.label12.Text = "保温时间";
            // 
            // label11
            // 
            this.label11.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(23, 134);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(53, 12);
            this.label11.TabIndex = 2;
            this.label11.Text = "升温速度";
            // 
            // label10
            // 
            this.label10.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(23, 72);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(53, 12);
            this.label10.TabIndex = 1;
            this.label10.Text = "装炉温度";
            // 
            // SchemeDesign
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(912, 582);
            this.Controls.Add(this.splitContainer1);
            this.Name = "SchemeDesign";
            this.Text = "工艺卡片";
            this.Load += new System.EventHandler(this.SchemeDesign_Load);
            this.splitContainer1.Panel1.ResumeLayout(false);
            this.splitContainer1.Panel1.PerformLayout();
            this.splitContainer1.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).EndInit();
            this.splitContainer1.ResumeLayout(false);
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            this.splitContainer2.Panel1.ResumeLayout(false);
            this.splitContainer2.Panel1.PerformLayout();
            this.splitContainer2.Panel2.ResumeLayout(false);
            this.splitContainer2.Panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer2)).EndInit();
            this.splitContainer2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.SplitContainer splitContainer1;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.SplitContainer splitContainer2;
        private System.Windows.Forms.TextBox xingneng_tx;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox beizhu_tx;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.TextBox pizhunren_tx;
        private System.Windows.Forms.TextBox shenheren_tx;
        private System.Windows.Forms.TextBox gongyiren_tx;
        private System.Windows.Forms.TextBox jianshu_tx;
        private System.Windows.Forms.TextBox baowen_tx;
        private System.Windows.Forms.TextBox shengwen_tx;
        private System.Windows.Forms.TextBox luwen_tx;
        private System.Windows.Forms.ComboBox comboBox1;
        public System.Windows.Forms.TextBox lingjian_tx;
        public System.Windows.Forms.TextBox tuzhi_tx;
        public System.Windows.Forms.TextBox cailiao_tx;
        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripButton toolStripButton2;
        private System.Windows.Forms.ToolStripButton toolStripButton1;
        private System.Windows.Forms.ComboBox gongyi_tx;
    }
}