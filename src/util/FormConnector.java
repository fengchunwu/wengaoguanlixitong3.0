package util;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormConnector {
    public Connection conn=null;
    private PreparedStatement psmt=null;
    private ResultSet rs=null;
    public void openConn(){
        //首先定义下连接数据的URL、用户名、密码
        String url="jdbc:mysql://127.0.0.1:3306/test1";
        String user="root";
        String password="123456";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,user,password);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List getRuleAllempByPage(int pageSize,int pageIndex){

        List list =new ArrayList();
        String sql;
        if(pageIndex==1)
        {
            String S=String.valueOf(pageSize);
            sql="SELECT * FROM `test1`.`Table_rule` ORDER BY `ID` ASC LIMIT "+S+";";
        }
        else if(pageIndex!=1 && pageSize*pageIndex<=countEmp("Table_rule"))
        {
            String S=String.valueOf(pageSize);
            String I=String.valueOf(pageSize*pageIndex);
            sql="SELECT * FROM (SELECT * FROM (SELECT * FROM `test1`.`Table_rule` LIMIT "+I+")LIMIT "+S+")ORDER BY ID ASC;";
        }
        else
        {
            String S=String.valueOf(countEmp("Table_rule")-pageSize*(pageIndex-1));
            String I=String.valueOf(countEmp("Table_rule"));
            sql="SELECT * FROM (SELECT * FROM (SELECT * FROM `test1`.`Table_rule` ORDER BY ID ASC LIMIT "+I+") ORDER BY ID DESC LIMIT "+S+") ORDER BY ID ASC;";
        }
        try {
            psmt=conn.prepareStatement(sql);
            rs=psmt.executeQuery();
            while(rs.next()){
                Map map=new HashMap();
                map.put("ID",rs.getInt("ID"));
                map.put("name",rs.getString("name"));
                map.put("time", rs.getString("time"));
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List getDraftAllempByPage(int pageSize,int pageIndex) {

        List list =new ArrayList();
        String sql;
        if(pageIndex==1)
        {
            String S=String.valueOf(pageSize);
            sql="SELECT * FROM `test1`.`Table_draftinfo` ORDER BY ID ASC LIMIT "+S+" ;";

        }
        else if(pageIndex!=1 && pageSize*pageIndex<=countEmp("Table_draftinfo"))
        {
            String S=String.valueOf(pageSize);
            String I=String.valueOf(pageSize*pageIndex);
            sql="SELECT * FROM (SELECT * FROM (SELECT * FROM `test1`.`Table_draftinfo` ORDER BY ID ASC LIMIT "+I+" ) ORDER BY ID DESC LIMIT "+S+" )ORDER BY ID ASC;";
        }
        else
        {
            String S=String.valueOf(countEmp("Table_draftinfo")-pageSize*(pageIndex-1));
            String I=String.valueOf(countEmp("Table_draftinfo"));
            sql="SELECT * FROM (SELECT * FROM (SELECT * FROM `test1`.`Table_draftinfo` ORDER BY ID ASC LIMIT "+I+" )ORDER BY ID DESC LIMIT "+S+" )ORDER BY ID ASC;";
        }
        try {
            psmt=conn.prepareStatement(sql);
            rs=psmt.executeQuery();
            while(rs.next()){
                Map map=new HashMap();
                map.put("ID", rs.getInt("ID"));
                map.put("name",rs.getString("name"));
                map.put("author", rs.getString("author"));
                map.put("deadline", rs.getString("deadline"));
                map.put("state", rs.getString("state"));
                map.put("support", rs.getString("support"));
                map.put("object", rs.getString("object"));
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List getCommonAllempByPage(int pageSize,int pageIndex,String essayid) {

        List list = new ArrayList();
        String sql;
        if (pageIndex == 1) {
            String S = String.valueOf(pageSize);
            sql = "SELECT * FROM `test1`.`Table_common` WHERE essayID = " + essayid + " LIMIT "+S+" ;";
        } else if (pageIndex != 1 && pageSize * pageIndex <= countEmp("Table_common")) {
            String S = String.valueOf(pageSize);
            String I = String.valueOf(pageSize * pageIndex);
            sql = "SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM `test1`.`Table_common` WHERE essayID = "+essayid+" ORDER BY ID DESC ) ORDER BY ID DESC LIMIT "+I+" ) ORDER BY ID ASC LIMIT "+S+" )ORDER BY ID DESC;";
        }
        else {
            String S = String.valueOf(countEmp("Table_common") - pageSize * (pageIndex - 1));
            String I = String.valueOf(countEmp("Table_common"));
            sql = "SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM `test1`.`Table_common` WHERE essayID = "+essayid+" ORDER BY ID DESC ) ORDER BY ID DESC LIMIT "+I+" ) ORDER BY ID ASC LIMIT "+S+" ) ORDER BY ID DESC;";
        }
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Map map = new HashMap();
                map.put("name", rs.getString("name"));
                map.put("essay", rs.getString("essay"));
                map.put("submittime", rs.getString("submittime"));
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List getUsersinfoAllempByPage(int pageSize,int pageIndex,String name){

        List list =new ArrayList();
        String sql;
        if(name.equals("null"))
        {
            if(pageIndex==1)
            {
                String S=String.valueOf(pageSize);
                sql="SELECT ID,name FROM (`test1`.`Table_users1` JOIN `test1`.`Table_usersinfo` ON `test1`.`Table_users1`.username = `test1`.`Table_usersinfo`.username) where status = '待审核' LIMIT "+S+" ;";
            }
            else if(pageIndex!=1 && pageSize*pageIndex<=countEmp("Table_users1"))
            {
                String S=String.valueOf(pageSize);
                String I=String.valueOf(pageSize*pageIndex);
                sql="SELECT * FROM (SELECT ID,name FROM (SELECT ID,name FROM (`test1`.`Table_users1` JOIN `test1`.`Table_usersinfo` ON `test1`.`Table_users1`.username = `test1`.`Table_usersinfo`.username) WHERE status = '待审核' ORDER BY name ASC LIMIT "+I+" ) ORDER BY ID DESC LIMIT "+S+" ) ORDER BY ID ASC;";
            }
            else
            {
                String S=String.valueOf(countEmp("Table_users1")-pageSize*(pageIndex-1)) ;
                String I=String.valueOf(countEmp("Table_users1"));
                sql="SELECT * FROM (SELECT ID,name FROM (SELECT ID,name FROM (`test1`.`Table_users1` JOIN `test1`.`Table_usersinfo` ON `test1`.`Table_users1`.username = `test1`.`Table_usersinfo`.username) WHERE status = '待审核'  ORDER BY ID ASC LIMIT "+I+" ) ORDER BY ID DESC LIMIT "+S+") ORDER BY ID ASC;";
            }
        }
        else
        {

            String S = String.valueOf(pageSize);
            sql = "SELECT ID,name FROM (`test1`.`Table_users1` JOIN `test1`.`Table_usersinfo` ON `test1`.`Table_users1`.username = `test1`.`Table_usersinfo`.username) WHERE name LIKE " + "'" + name + "%'" + " AND  status = '待审核' ;";
        }
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Map map = new HashMap();
                map.put("ID", rs.getInt("ID"));
                map.put("name", rs.getString("name"));
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List getDraft_ApprovalAllempByPage(int pageSize,int pageIndex,String state) {

        List list =new ArrayList();
        String sql;
        if(pageIndex==1)
        {
            String S=String.valueOf(pageSize);
            sql="SELECT * FROM `test1`.`Table_draftinfo` WHERE state = '"+state+"' ORDER BY ID ASC LIMIT "+S+" ;";
        }
        else if(pageIndex!=1 && pageSize*pageIndex<=countEmp("Table_draftinfo" ))
        {
            String S=String.valueOf(pageSize);
            String I=String.valueOf(pageSize*pageIndex);
            sql="SELECT * FROM (SELECT * FROM (SELECT * FROM `test1`.`Table_draftinfo` WHERE state = "+"'"+state+"'"+" ORDER BY ID ASC LIMIT "+I+" )ORDER BY ID DESC "+S+" ) ORDER BY ID ASC;";
        }
        else
        {
            String S=String.valueOf(countEmp("Table_draftinfo")-pageSize*(pageIndex-1));
            String I=String.valueOf(countEmp("Table_draftinfo"));
            sql="SELECT * FROM (SELECT * FROM (SELECT * FROM `test1`.`Table_draftinfo` WHERE state = "+"'"+state+"'"+"  ORDER BY ID ASC LIMIT "+I+" )ORDER BY ID DESC "+S+" )ORDER BY ID ASC;";
        }
        try {
            psmt=conn.prepareStatement(sql);
            rs=psmt.executeQuery();
            while(rs.next()){
                Map map=new HashMap();
                map.put("ID", rs.getInt("ID"));
                map.put("name",rs.getString("name"));
                map.put("author", rs.getString("author"));
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //得到表的总数
    public int countEmp(String Table){

        int count=0;
        String sql="SELECT COUNT(*) FROM `test1`.`"+Table+"`;";
        try {
            psmt=conn.prepareStatement(sql);
            rs=psmt.executeQuery();
            while(rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    //根据每页显示的数量,得到总页数
    public int getTotalPage(int pageSize,String Table){

        int totalPage=countEmp(Table);
        return (totalPage%pageSize==0)?(totalPage/pageSize):(totalPage/pageSize+1);
    }
    //从某表（Table）中读取某个属性（type）中的某个数据，当某属性（KeyType）等于某值时（Key），并以String类型输出
    public String SELECTDate(String Table,String KeyType,String Key ,String type) {

        try {
            String sql="SELECT "+type+" FROM `test1`.`"+Table+"` WHERE "+KeyType+" = "+"'"+Key+"';" ;
            Statement stmt=null;
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            String result=rs.getString(type);
            //完成后记得关闭数据库连接   
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "NULL";
    }
}
