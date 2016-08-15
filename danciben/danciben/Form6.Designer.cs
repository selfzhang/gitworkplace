namespace danciben
{
    partial class Form6
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
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form6));
            this.plan_box = new System.Windows.Forms.TextBox();
            this.down_bt = new System.Windows.Forms.Button();
            this.return_bt = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.no_txt = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // plan_box
            // 
            this.plan_box.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.plan_box.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.plan_box.Location = new System.Drawing.Point(128, 279);
            this.plan_box.Multiline = true;
            this.plan_box.Name = "plan_box";
            this.plan_box.Size = new System.Drawing.Size(375, 130);
            this.plan_box.TabIndex = 1;
            this.plan_box.Text = "新增计划内容";
            // 
            // down_bt
            // 
            this.down_bt.Location = new System.Drawing.Point(126, 430);
            this.down_bt.Name = "down_bt";
            this.down_bt.Size = new System.Drawing.Size(82, 41);
            this.down_bt.TabIndex = 2;
            this.down_bt.Text = "添加";
            this.down_bt.UseVisualStyleBackColor = true;
            this.down_bt.Click += new System.EventHandler(this.down_bt_Click);
            // 
            // return_bt
            // 
            this.return_bt.Location = new System.Drawing.Point(422, 430);
            this.return_bt.Name = "return_bt";
            this.return_bt.Size = new System.Drawing.Size(81, 41);
            this.return_bt.TabIndex = 3;
            this.return_bt.Text = "返回";
            this.return_bt.UseVisualStyleBackColor = true;
            this.return_bt.Click += new System.EventHandler(this.return_bt_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.label1.Location = new System.Drawing.Point(126, 57);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 12);
            this.label1.TabIndex = 4;
            this.label1.Text = "已定计划";
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dataGridView1.AutoSizeRowsMode = System.Windows.Forms.DataGridViewAutoSizeRowsMode.AllCells;
            this.dataGridView1.BackgroundColor = System.Drawing.SystemColors.ButtonHighlight;
            this.dataGridView1.CellBorderStyle = System.Windows.Forms.DataGridViewCellBorderStyle.None;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dataGridView1.Location = new System.Drawing.Point(128, 71);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.RowTemplate.Height = 23;
            this.dataGridView1.Size = new System.Drawing.Size(375, 152);
            this.dataGridView1.TabIndex = 5;
            this.dataGridView1.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            this.dataGridView1.CellContentDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // no_txt
            // 
            this.no_txt.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.no_txt.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.no_txt.Location = new System.Drawing.Point(128, 245);
            this.no_txt.Multiline = true;
            this.no_txt.Name = "no_txt";
            this.no_txt.Size = new System.Drawing.Size(375, 33);
            this.no_txt.TabIndex = 6;
            this.no_txt.Text = "填写新增计划的重要度  数字越大与重要";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.label2.Location = new System.Drawing.Point(126, 229);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 12);
            this.label2.TabIndex = 7;
            this.label2.Text = "制定计划";
            // 
            // Form6
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(594, 538);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.no_txt);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.return_bt);
            this.Controls.Add(this.down_bt);
            this.Controls.Add(this.plan_box);
            this.Name = "Form6";
            this.Text = "复习计划";
            this.Load += new System.EventHandler(this.Form6_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox plan_box;
        private System.Windows.Forms.Button down_bt;
        private System.Windows.Forms.Button return_bt;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.TextBox no_txt;
        private System.Windows.Forms.Label label2;
    }
}