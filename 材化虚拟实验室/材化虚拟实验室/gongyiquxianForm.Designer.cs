namespace 材化虚拟实验室
{
    partial class gongyiquxianForm
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(gongyiquxianForm));
            this.axWebOffice1 = new AxWEBOFFICELib.AxWebOffice();
            this.axWebOffice2 = new AxWEBOFFICELib.AxWebOffice();
            ((System.ComponentModel.ISupportInitialize)(this.axWebOffice1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.axWebOffice2)).BeginInit();
            this.SuspendLayout();
            // 
            // axWebOffice1
            // 
            this.axWebOffice1.Enabled = true;
            this.axWebOffice1.Location = new System.Drawing.Point(0, 0);
            this.axWebOffice1.Name = "axWebOffice1";
            this.axWebOffice1.Size = new System.Drawing.Size(75, 23);
            this.axWebOffice1.TabIndex = 0;
            // 
            // axWebOffice2
            // 
            this.axWebOffice2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.axWebOffice2.Enabled = true;
            this.axWebOffice2.Location = new System.Drawing.Point(0, 0);
            this.axWebOffice2.Name = "axWebOffice2";
            this.axWebOffice2.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("axWebOffice2.OcxState")));
            this.axWebOffice2.Size = new System.Drawing.Size(746, 443);
            this.axWebOffice2.TabIndex = 1;
            // 
            // gongyiquxianForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(746, 443);
            this.Controls.Add(this.axWebOffice2);
            this.Name = "gongyiquxianForm";
            this.Text = "工艺曲线";
            this.Load += new System.EventHandler(this.wordForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.axWebOffice1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.axWebOffice2)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private AxWEBOFFICELib.AxWebOffice axWebOffice1;
        private AxWEBOFFICELib.AxWebOffice axWebOffice2;
    }
}