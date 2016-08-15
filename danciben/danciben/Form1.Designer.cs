namespace danciben
{
    partial class Form1
    {
        /// <summary>
        /// 設計工具所需的變數。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清除任何使用中的資源。
        /// </summary>
        /// <param name="disposing">如果應該處置 Managed 資源則為 true，否則為 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form 設計工具產生的程式碼

        /// <summary>
        /// 此為設計工具支援所需的方法 - 請勿使用程式碼編輯器
        /// 修改這個方法的內容。
        /// </summary>
        private void InitializeComponent()
        {
            this.english_chiness = new System.Windows.Forms.Button();
            this.wrong_words = new System.Windows.Forms.Button();
            this.test = new System.Windows.Forms.Button();
            this.game_bt = new System.Windows.Forms.Button();
            this.quit_bt = new System.Windows.Forms.Button();
            this.plan_bt = new System.Windows.Forms.Button();
            this.set_bt = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // english_chiness
            // 
            this.english_chiness.BackgroundImage = global::danciben.Properties.Resources.translate;
            this.english_chiness.Location = new System.Drawing.Point(312, 185);
            this.english_chiness.Name = "english_chiness";
            this.english_chiness.Size = new System.Drawing.Size(116, 53);
            this.english_chiness.TabIndex = 1;
            this.english_chiness.Text = "翻译";
            this.english_chiness.UseVisualStyleBackColor = true;
            this.english_chiness.Click += new System.EventHandler(this.english_chiness_Click);
            // 
            // wrong_words
            // 
            this.wrong_words.BackgroundImage = global::danciben.Properties.Resources.test1;
            this.wrong_words.Location = new System.Drawing.Point(373, 240);
            this.wrong_words.Name = "wrong_words";
            this.wrong_words.Size = new System.Drawing.Size(108, 50);
            this.wrong_words.TabIndex = 3;
            this.wrong_words.Text = "错题集";
            this.wrong_words.UseVisualStyleBackColor = true;
            this.wrong_words.Click += new System.EventHandler(this.wrong_words_Click);
            // 
            // test
            // 
            this.test.BackColor = System.Drawing.SystemColors.Window;
            this.test.BackgroundImage = global::danciben.Properties.Resources.test1;
            this.test.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.test.Location = new System.Drawing.Point(424, 74);
            this.test.Name = "test";
            this.test.Size = new System.Drawing.Size(115, 58);
            this.test.TabIndex = 4;
            this.test.Text = "能力测试";
            this.test.UseVisualStyleBackColor = false;
            this.test.Click += new System.EventHandler(this.test_Click);
            // 
            // game_bt
            // 
            this.game_bt.BackColor = System.Drawing.Color.LightSkyBlue;
            this.game_bt.BackgroundImage = global::danciben.Properties.Resources.test1;
            this.game_bt.Location = new System.Drawing.Point(369, 132);
            this.game_bt.Name = "game_bt";
            this.game_bt.Size = new System.Drawing.Size(112, 51);
            this.game_bt.TabIndex = 5;
            this.game_bt.Text = "小游戏";
            this.game_bt.UseVisualStyleBackColor = false;
            this.game_bt.Click += new System.EventHandler(this.game_bt_Click);
            // 
            // quit_bt
            // 
            this.quit_bt.BackgroundImage = global::danciben.Properties.Resources.set;
            this.quit_bt.Location = new System.Drawing.Point(428, 400);
            this.quit_bt.Name = "quit_bt";
            this.quit_bt.Size = new System.Drawing.Size(112, 57);
            this.quit_bt.TabIndex = 6;
            this.quit_bt.Text = "退出";
            this.quit_bt.UseVisualStyleBackColor = true;
            this.quit_bt.Click += new System.EventHandler(this.quit_bt_Click);
            // 
            // plan_bt
            // 
            this.plan_bt.BackgroundImage = global::danciben.Properties.Resources.test2;
            this.plan_bt.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.plan_bt.Image = global::danciben.Properties.Resources.test1;
            this.plan_bt.Location = new System.Drawing.Point(312, 294);
            this.plan_bt.Name = "plan_bt";
            this.plan_bt.Size = new System.Drawing.Size(122, 51);
            this.plan_bt.TabIndex = 7;
            this.plan_bt.Text = "复习计划";
            this.plan_bt.UseVisualStyleBackColor = true;
            this.plan_bt.Click += new System.EventHandler(this.plan_bt_Click);
            // 
            // set_bt
            // 
            this.set_bt.BackgroundImage = global::danciben.Properties.Resources.game;
            this.set_bt.Location = new System.Drawing.Point(372, 346);
            this.set_bt.Name = "set_bt";
            this.set_bt.Size = new System.Drawing.Size(111, 53);
            this.set_bt.TabIndex = 8;
            this.set_bt.Text = "游戏设置";
            this.set_bt.UseVisualStyleBackColor = true;
            this.set_bt.Click += new System.EventHandler(this.set_bt_Click);
            // 
            // label1
            // 
            this.label1.Font = new System.Drawing.Font("宋体", 26.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.Image = global::danciben.Properties.Resources.Redocn_20120306030358611;
            this.label1.ImageAlign = System.Drawing.ContentAlignment.TopRight;
            this.label1.Location = new System.Drawing.Point(-2, -3);
            this.label1.Name = "label1";
            this.label1.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.label1.Size = new System.Drawing.Size(127, 457);
            this.label1.TabIndex = 9;
            this.label1.Text = "单词本";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // Form1
            // 
            this.AllowDrop = true;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Highlight;
            this.BackgroundImage = global::danciben.Properties.Resources.Redocn_20120306030358611;
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.ClientSize = new System.Drawing.Size(662, 528);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.set_bt);
            this.Controls.Add(this.plan_bt);
            this.Controls.Add(this.quit_bt);
            this.Controls.Add(this.game_bt);
            this.Controls.Add(this.test);
            this.Controls.Add(this.wrong_words);
            this.Controls.Add(this.english_chiness);
            this.Name = "Form1";
            this.Text = "单词本";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button english_chiness;
        private System.Windows.Forms.Button wrong_words;
        private System.Windows.Forms.Button test;
        private System.Windows.Forms.Button game_bt;
        private System.Windows.Forms.Button quit_bt;
        private System.Windows.Forms.Button plan_bt;
        private System.Windows.Forms.Button set_bt;
        private System.Windows.Forms.Label label1;

    }
}

