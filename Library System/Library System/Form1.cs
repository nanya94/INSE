using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Web;
using Microsoft.SqlServer;
using System.IO;
using System.Data.SqlClient;
using System.Data.OleDb;


namespace Library_System
{

    public partial class LibrarySystem : Form
    {
        //Author: 731645


        //defining images
        Image groundmap;
        Image firstmap;
        Image secondmap;
        Image groundmappoint;
        Image firstmappoint;
        Image secondmappoint;


        public LibrarySystem()
        {

            InitializeComponent();

            //Database Location
            string connString = @"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=C:\Users\RCP\Documents\Visual Studio 2015\Projects\Library System\Library System\Seating.accdb";
            using (OleDbConnection connection = new OleDbConnection(connString))
            {
                connection.Open();
                using (OleDbCommand dataCommand = connection.CreateCommand())
                {
                    Random rnd = new Random();
                    int rn = rnd.Next(1, 100);
                    //get 1 seat from seating database
                    dataCommand.CommandText = "SELECT TOP 1 * FROM floors where ID=" + rn;
                    
                    DataTable table = new DataTable();
                    OleDbDataAdapter adapter = new OleDbDataAdapter();
                    adapter.SelectCommand = dataCommand;
                    adapter.Fill(table);
                    seatingDataSet1BindingSource.DataSource = table;
                    dataGridView1.AutoResizeColumns(DataGridViewAutoSizeColumnsMode.AllCellsExceptHeader);
                    dataGridView1.ReadOnly = true;
                    dataGridView1.DataSource = seatingDataSet1BindingSource;
                    //query outputted into a datagrid

                }
                
            }
            //map and point file locations
            gmapbox.Controls.Add(gmappointbox);
            gmappointbox.BackColor = Color.Transparent;
            gmapbox.Image = Image.FromFile(@"C:\Users\RCP\Documents\Visual Studio 2015\Projects\Library System\groundfloor.jpg");
            groundmap = gmapbox.Image;
            gmappointbox.Image = Image.FromFile(@"C:\Users\RCP\Documents\Visual Studio 2015\Projects\Library System\Point.png");
            groundmappoint = gmappointbox.Image;

            mapbox2.Controls.Add(mappointbox2);
            mappointbox2.BackColor = Color.Transparent;
            mapbox2.Image = Image.FromFile(@"C:\Users\RCP\Documents\Visual Studio 2015\Projects\Library System\firstfloor.jpg");
            firstmap = mapbox2.Image;
            mappointbox2.Image = Image.FromFile(@"C:\Users\RCP\Documents\Visual Studio 2015\Projects\Library System\Point.png");
            firstmappoint = mappointbox2.Image;

            mapbox3.Controls.Add(mappointbox3);
            mappointbox3.BackColor = Color.Transparent;
            mapbox3.Image = Image.FromFile(@"C:\Users\RCP\Documents\Visual Studio 2015\Projects\Library System\secondfloor.jpg");
            secondmap = mapbox3.Image;
            mappointbox3.Image = Image.FromFile(@"C:\Users\RCP\Documents\Visual Studio 2015\Projects\Library System\Point.png");
            secondmappoint = mappointbox3.Image;

        }
        //Auto sizing panel box components
        private void GroundFloorpanel_Paint(object sender, PaintEventArgs e)
        {
            
            GroundFloorpanel.AutoScroll = true;
            gmapbox.SizeMode = PictureBoxSizeMode.AutoSize;
            gmappointbox.SizeMode = PictureBoxSizeMode.AutoSize;          
        }
        

        private void FirstFloorpanel_Paint(object sender, PaintEventArgs e)
        {
            FirstFloorpanel.AutoScroll = true;
            mapbox2.SizeMode = PictureBoxSizeMode.AutoSize;
            mappointbox2.SizeMode = PictureBoxSizeMode.AutoSize;
        }

        private void SecondFloorpanel_Paint(object sender, PaintEventArgs e)
        {
            SecondFloorpanel.AutoScroll = true;
            mapbox3.SizeMode = PictureBoxSizeMode.AutoSize;
            mappointbox3.SizeMode = PictureBoxSizeMode.AutoSize;
        }
    
        //ground floor map zoom slider
        Image Zoom(Image floormap, Size size)
        {
            Bitmap bmpzoom1 = new Bitmap(floormap, (floormap.Width + (floormap.Width * size.Width / 100)) / 5, (floormap.Height + (floormap.Height * size.Height / 100)) / 5);
            Graphics gen = Graphics.FromImage(bmpzoom1);
            gen.InterpolationMode = System.Drawing.Drawing2D.InterpolationMode.HighQualityBicubic;
            return bmpzoom1;

        }
        //ground floor map point zoom slider
        Image PointZoom(Image floormappoint, Size size)
        {

            int i;
            i = dataGridView1.SelectedCells[0].RowIndex;
            XBox.Text = dataGridView1.Rows[i].Cells["gx"].Value.ToString();
            YBox.Text = dataGridView1.Rows[i].Cells["gy"].Value.ToString();
            
            int gx = Convert.ToInt32(this.XBox.Text);
            int gy = Convert.ToInt32(this.YBox.Text);
            
            
            gx = gx - 100;
            gy = gy - 100;
            

            Bitmap bmppzoom1 = new Bitmap(floormappoint, (floormappoint.Width + (floormappoint.Width * size.Width / 100)), (floormappoint.Height + (floormappoint.Height * size.Height / 100)));
            Graphics genpzoom1 = Graphics.FromImage(bmppzoom1);
            genpzoom1.InterpolationMode = System.Drawing.Drawing2D.InterpolationMode.HighQualityBicubic;
            Point gpointl = new Point((gx + (gx * size.Width / 100)), (gy + (gy * size.Width / 100)));
            

            gmappointbox.Location = gpointl;
            

            return bmppzoom1;

        }
        //first floor map zoom slider
        Image Zoom2(Image floormap, Size size)
        {
            Bitmap bmpzoom2 = new Bitmap(floormap, (floormap.Width + (floormap.Width * size.Width / 100)) / 5, (floormap.Height + (floormap.Height * size.Height / 100)) / 5);
            Graphics genzoom2 = Graphics.FromImage(bmpzoom2);
            genzoom2.InterpolationMode = System.Drawing.Drawing2D.InterpolationMode.HighQualityBicubic;
            return bmpzoom2;

        }
        //first floor map point zoom slider
        Image PointZoom2(Image floormappoint, Size size)
        {

            int i;
            i = dataGridView1.SelectedCells[0].RowIndex;
            
            XBox2.Text = dataGridView1.Rows[i].Cells["fx"].Value.ToString();
            YBox2.Text = dataGridView1.Rows[i].Cells["fy"].Value.ToString();
                        
            int fx = Convert.ToInt32(this.XBox2.Text);
            int fy = Convert.ToInt32(this.YBox2.Text);
                                   
            fx = fx - 100;
            fy = fy - 100;
            
            Bitmap bmppzoom2 = new Bitmap(floormappoint, (floormappoint.Width + (floormappoint.Width * size.Width / 100)), (floormappoint.Height + (floormappoint.Height * size.Height / 100)));
            Graphics genpzoom2 = Graphics.FromImage(bmppzoom2);
            genpzoom2.InterpolationMode = System.Drawing.Drawing2D.InterpolationMode.HighQualityBicubic;
            
            Point gpoint2 = new Point((fx + (fx * size.Width / 100)), (fy + (fy * size.Width / 100)));
                        
            mappointbox2.Location = gpoint2;
            
            return bmppzoom2;

        }
        //second floor map zoom slider
        Image Zoom3(Image floormap, Size size)
        {
            Bitmap bmpzoom3 = new Bitmap(floormap, (floormap.Width + (floormap.Width * size.Width / 100)) / 5, (floormap.Height + (floormap.Height * size.Height / 100)) / 5);
            Graphics genzoom3 = Graphics.FromImage(bmpzoom3);
            genzoom3.InterpolationMode = System.Drawing.Drawing2D.InterpolationMode.HighQualityBicubic;
            return bmpzoom3;

        }
        //second floor map point zoom slider
        Image PointZoom3(Image floormappoint, Size size)
        {

            int i;
            i = dataGridView1.SelectedCells[0].RowIndex;
            
            XBox3.Text = dataGridView1.Rows[i].Cells["sx"].Value.ToString();
            YBox3.Text = dataGridView1.Rows[i].Cells["sy"].Value.ToString();
            
            int sx = Convert.ToInt32(this.XBox3.Text);
            int sy = Convert.ToInt32(this.YBox3.Text);
                        
            sx = sx - 100;
            sy = sy - 100;

            Bitmap bmppzoom3 = new Bitmap(floormappoint, (floormappoint.Width + (floormappoint.Width * size.Width / 100)), (floormappoint.Height + (floormappoint.Height * size.Height / 100)));
            Graphics genpzoom3 = Graphics.FromImage(bmppzoom3);
            genpzoom3.InterpolationMode = System.Drawing.Drawing2D.InterpolationMode.HighQualityBicubic;
            
            Point gpoint3 = new Point((sx + (sx * size.Width / 100)), (sy + (sy * size.Width / 100)));
                        
            mappointbox3.Location = gpoint3;

            return bmppzoom3;

        }
        //scroll bar map and point value configuration
        private void Zoombar_Scroll(object sender, EventArgs e)
        {
            gmapbox.Image = Zoom(groundmap, new Size(Zoombar.Value, Zoombar.Value));
            gmappointbox.Image = PointZoom(groundmappoint, new Size(Zoombar.Value, Zoombar.Value));
            mapbox2.Image = Zoom2(firstmap, new Size(Zoombar.Value, Zoombar.Value));
            mappointbox2.Image = PointZoom2(firstmappoint, new Size(Zoombar.Value, Zoombar.Value));
            mapbox3.Image = Zoom3(secondmap, new Size(Zoombar.Value, Zoombar.Value));
            mappointbox3.Image = PointZoom3(secondmappoint, new Size(Zoombar.Value, Zoombar.Value));
        }

        private void bookbutton_Click(object sender, EventArgs e)
        {
            OleDbConnection conn = new OleDbConnection();
            conn.ConnectionString = @"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=C:\Users\RCP\Documents\Visual Studio 2015\Projects\Library System\Library System\Seating.accdb";
            try
            {
                conn.Open();
                String SeatType = SeatTypeBox.Text.ToString();
                String Floor = FloorBox.Text.ToString();
                String Date = DateBox.Text.ToString();
                String StartTime = StartTimeBox.Text.ToString();
                String Length = LengthBox.Text.ToString();
                String ins = "insert into bookinglist (SeatType,Floor,Date,StartTime, Length) Values('" + SeatType+ "','" + Floor + "','" + Date + "','" + StartTime + "','" + Length + "')";

                OleDbCommand cmd = new OleDbCommand(ins, conn);
                cmd.ExecuteNonQuery();

                MessageBox.Show("Data saved successfuly...!");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Failed due to" + ex.Message);
            }
            finally
            {
                conn.Close();
            }

                
        }
    }
}
