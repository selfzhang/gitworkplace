using System.Windows.Forms;
namespace 材化虚拟实验室
{
    partial class Form2
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
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
            
            ctF.Close();
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.TreeNode treeNode41 = new System.Windows.Forms.TreeNode("热处理工艺演示");
            System.Windows.Forms.TreeNode treeNode42 = new System.Windows.Forms.TreeNode("工艺介绍");
            System.Windows.Forms.TreeNode treeNode43 = new System.Windows.Forms.TreeNode("简介", new System.Windows.Forms.TreeNode[] {
            treeNode41,
            treeNode42});
            System.Windows.Forms.TreeNode treeNode44 = new System.Windows.Forms.TreeNode("材料库");
            System.Windows.Forms.TreeNode treeNode45 = new System.Windows.Forms.TreeNode("零件库");
            System.Windows.Forms.TreeNode treeNode46 = new System.Windows.Forms.TreeNode("图纸库");
            System.Windows.Forms.TreeNode treeNode47 = new System.Windows.Forms.TreeNode("工艺曲线");
            System.Windows.Forms.TreeNode treeNode48 = new System.Windows.Forms.TreeNode("方案设计", new System.Windows.Forms.TreeNode[] {
            treeNode44,
            treeNode45,
            treeNode46,
            treeNode47});
            System.Windows.Forms.TreeNode treeNode49 = new System.Windows.Forms.TreeNode("温度场");
            System.Windows.Forms.TreeNode treeNode50 = new System.Windows.Forms.TreeNode("X轴方向应力_Y轴方向应力");
            System.Windows.Forms.TreeNode treeNode51 = new System.Windows.Forms.TreeNode("Ｚ轴方向应力_Misses应力场");
            System.Windows.Forms.TreeNode treeNode52 = new System.Windows.Forms.TreeNode("残余应力分布云图");
            System.Windows.Forms.TreeNode treeNode53 = new System.Windows.Forms.TreeNode("应力场", new System.Windows.Forms.TreeNode[] {
            treeNode50,
            treeNode51,
            treeNode52});
            System.Windows.Forms.TreeNode treeNode54 = new System.Windows.Forms.TreeNode("组织场");
            System.Windows.Forms.TreeNode treeNode55 = new System.Windows.Forms.TreeNode("多场实时变化");
            System.Windows.Forms.TreeNode treeNode56 = new System.Windows.Forms.TreeNode("实验过程", new System.Windows.Forms.TreeNode[] {
            treeNode49,
            treeNode53,
            treeNode54,
            treeNode55});
            System.Windows.Forms.TreeNode treeNode57 = new System.Windows.Forms.TreeNode("硬度");
            System.Windows.Forms.TreeNode treeNode58 = new System.Windows.Forms.TreeNode("拉伸");
            System.Windows.Forms.TreeNode treeNode59 = new System.Windows.Forms.TreeNode("冲击韧性");
            System.Windows.Forms.TreeNode treeNode60 = new System.Windows.Forms.TreeNode("结果检验", new System.Windows.Forms.TreeNode[] {
            treeNode57,
            treeNode58,
            treeNode59});
            this.splitContainer1 = new System.Windows.Forms.SplitContainer();
            this.treeView1 = new System.Windows.Forms.TreeView();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).BeginInit();
            this.splitContainer1.Panel1.SuspendLayout();
            this.splitContainer1.SuspendLayout();
            this.SuspendLayout();
            // 
            // splitContainer1
            // 
            this.splitContainer1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer1.Location = new System.Drawing.Point(0, 0);
            this.splitContainer1.Name = "splitContainer1";
            // 
            // splitContainer1.Panel1
            // 
            this.splitContainer1.Panel1.Controls.Add(this.treeView1);
            this.splitContainer1.Size = new System.Drawing.Size(1350, 690);
            this.splitContainer1.SplitterDistance = 309;
            this.splitContainer1.TabIndex = 6;
            // 
            // treeView1
            // 
            this.treeView1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.treeView1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.treeView1.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.treeView1.Indent = 30;
            this.treeView1.ItemHeight = 20;
            this.treeView1.Location = new System.Drawing.Point(0, 0);
            this.treeView1.Name = "treeView1";
            treeNode41.Name = "Node5";
            treeNode41.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode41.Text = "热处理工艺演示";
            treeNode42.Name = "Node10";
            treeNode42.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode42.Text = "工艺介绍";
            treeNode43.Name = "Node4";
            treeNode43.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode43.Text = "简介";
            treeNode44.Name = "Node1";
            treeNode44.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode44.Text = "材料库";
            treeNode45.Name = "Node2";
            treeNode45.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode45.Text = "零件库";
            treeNode46.Name = "Node3";
            treeNode46.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode46.Text = "图纸库";
            treeNode47.Name = "Node0";
            treeNode47.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode47.Text = "工艺曲线";
            treeNode48.Name = "Node0";
            treeNode48.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode48.Text = "方案设计";
            treeNode49.Name = "Node12";
            treeNode49.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode49.Text = "温度场";
            treeNode50.Name = "Node2";
            treeNode50.Text = "X轴方向应力_Y轴方向应力";
            treeNode51.Name = "Node3";
            treeNode51.Text = "Ｚ轴方向应力_Misses应力场";
            treeNode52.Name = "Node4";
            treeNode52.Text = "残余应力分布云图";
            treeNode53.Name = "Node13";
            treeNode53.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode53.Text = "应力场";
            treeNode54.Name = "Node14";
            treeNode54.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode54.Text = "组织场";
            treeNode55.Name = "Node15";
            treeNode55.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode55.Text = "多场实时变化";
            treeNode56.Name = "Node11";
            treeNode56.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode56.Text = "实验过程";
            treeNode57.Name = "Node17";
            treeNode57.Text = "硬度";
            treeNode58.Name = "Node18";
            treeNode58.Text = "拉伸";
            treeNode59.Name = "Node2";
            treeNode59.Text = "冲击韧性";
            treeNode60.Name = "Node16";
            treeNode60.NodeFont = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            treeNode60.Text = "结果检验";
            this.treeView1.Nodes.AddRange(new System.Windows.Forms.TreeNode[] {
            treeNode43,
            treeNode48,
            treeNode56,
            treeNode60});
            this.treeView1.Size = new System.Drawing.Size(309, 690);
            this.treeView1.TabIndex = 4;
            this.treeView1.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.treeView1_AfterSelect);
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1350, 690);
            this.Controls.Add(this.splitContainer1);
            this.Name = "Form2";
            this.Text = "热处理";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.Form2_Load);
            this.splitContainer1.Panel1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).EndInit();
            this.splitContainer1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TreeView treeView1;
        public System.Windows.Forms.SplitContainer splitContainer1;




    }
}