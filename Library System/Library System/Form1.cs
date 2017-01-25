using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Library_System
{
    public partial class LibrarySystem : Form
    {
        public LibrarySystem()
        {
            InitializeComponent();
            
        }

        private void GroundFloorTab_Click(object sender, EventArgs e)
        {
            
        }

        private void GroundFloorpanel_Paint(object sender, PaintEventArgs e)
        {
            GroundFloorpanel.AutoScroll = true;
        }

        private void Grid_Click(object sender, EventArgs e)
        {
            int X = 80;
            int Y = 50;
            X = X + 20;
            Y = Y + 20;
            Point Coords = new Point(X, Y);
            PictureBox map = new PictureBox();
            map.Image = Image.FromFile("C:/Users/RCP/Documents/Visual Studio 2015/Projects/Library System/GroundFloor.jpg");
            map.Visible = true;
            map.Dock = DockStyle.Fill;
            map.Location = Coords;
            map.BringToFront();
            map.SizeMode = PictureBoxSizeMode.AutoSize;
            map.Dock = DockStyle.Fill;
            GroundFloorpanel.Controls.Add(map);

            int top = 50;
            int left = 80;
            for (int j = 0; j < 10; j++)
            {
                for (int i = 0; i < 10; i++)
                {
                    Button grid = new Button();
                    grid.Left = left;
                    grid.Top = top;
                    grid.Width = 5;
                    grid.Height = 5;
                    grid.TabStop = false;
                    grid.FlatStyle = FlatStyle.Flat;
                    grid.FlatAppearance.BorderSize = 0;
                    grid.FlatAppearance.BorderColor = Color.FromArgb(0, 255, 255, 255);
                    grid.ForeColor = Color.Aquamarine;
                    grid.BackColor = Color.FromArgb(100, Color.Red);
                    this.Controls.Add(grid);
                    top += grid.Height;
                    grid.BringToFront();
                    
                }

            }
            

        }

        private void label8_Click(object sender, EventArgs e)
        {

        }
    }
    }
