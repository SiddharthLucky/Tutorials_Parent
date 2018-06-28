using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _8_ListBox
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(textBox1.Text.Length > 0)
            {
                ArrayList items = new ArrayList();
                for(int i=0; i< listBox1.Items.Count; ++i)
                {
                    items.Add(listBox1.Items[i]);
                }
                listBox1.Items.Clear();

                items.Add(textBox1.Text);
                items.Sort();
                foreach(string item in items)
                {
                    listBox1.Items.Add(item);
                }
                textBox1.Text = "";
            }
        }
    }
}
