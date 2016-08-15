using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 材化虚拟实验室
{
    class excel
    {    
        DataTable ExcelTable;
        public excel() {
           
        }

       
        //Excel的连接 
        public DataSet ExcelToDataSet(string filename)
        {
            DataSet ds;
            string strCon = "Provider=Microsoft.Jet.OLEDB.4.0;" + "data source=" + filename +
                            ";Extended Properties='Excel 8.0;HDR=NO; IMEX=1' "; //注意Excel 8.0; Imex=1或Excel 8.0; Imex=1; no=1要加单引号  
            OleDbConnection myConn = new OleDbConnection(strCon);
            string strCom = " SELECT * FROM [Sheet1$]";
            myConn.Open();
            OleDbDataAdapter myCommand = new OleDbDataAdapter(strCom, myConn); ds = new DataSet();
            myCommand.Fill(ds, "[Sheet1$]"); 
            myConn.Close();
            return ds;
        }

        public void readExcel(String sExcelFile)
        {
            DataSet ds = new DataSet();
            string strCon = @"Provider=Microsoft.Jet.OLEDB.4.0; Data Source =" + sExcelFile + ";Extended Properties='Excel 8.0;HDR=NO; IMEX=1'";
            OleDbConnection objConn = new OleDbConnection(strCon);
            try
            {
                objConn.Open();
            }catch(Exception e){
                MessageBox.Show(e.ToString());
            }

           DataTable schemaTable = objConn.GetOleDbSchemaTable(System.Data.OleDb.OleDbSchemaGuid.Tables, null);
           string tableName = schemaTable.Rows[0][2].ToString().Trim();//获取 Excel 的表名，默认值是sheet1 
             
            
            string strSql = "select * from [" + tableName + "];";
            OleDbCommand objCmd = new OleDbCommand(strSql, objConn);
            OleDbDataAdapter myData = new OleDbDataAdapter(strSql, objConn);

            myData.Fill(ds, tableName);//填充数据  
            objConn.Close();
            ExcelTable = ds.Tables[tableName];
            
            
        }

        public double[] setX(string sExcelFile, double[] Xdata)
        {
           
                readExcel(sExcelFile);
                Xdata = new double[ExcelTable.Rows.Count];
                for (int i = 1; i < ExcelTable.Rows.Count; i++)
                {
                    Xdata[i - 1] = double.Parse(ExcelTable.Rows[i][0].ToString());
                }
           
            return Xdata;
        }

        public string[] setName(string sExcelFile, string[] name)
        {
            readExcel(sExcelFile);
                name = new string[ExcelTable.Columns.Count];
                for (int i = 1; i < ExcelTable.Columns.Count; i++)
                {
                    name[i - 1] = ExcelTable.Rows[0][i].ToString();
                }
           
            return name;
        }
        
        public string[,] readData(string sExcelFile, string[,] storedata)
        {
            
                readExcel(sExcelFile);
                int iColums = ExcelTable.Columns.Count;//列数    
                int iRows = ExcelTable.Rows.Count;//行数 
                //定义二维数组存储 Excel 表中读取的数据 
                storedata = new string[iRows - 1, iColums - 1];
                for (int i = 1; i < ExcelTable.Rows.Count; i++)
                {
                    for (int j = 1; j < ExcelTable.Columns.Count; j++)
                    {
                        //将Excel表中的数据存储到数组 
                        storedata[i - 1, j - 1] = ExcelTable.Rows[i][j].ToString();
                    }
                }
          
            
            return storedata;
        }
    }
}
