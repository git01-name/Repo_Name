package hxj;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.sun.istack.internal.logging.Logger;

import hxj.dao.UserMapper;
import pojo.User;
public class uu {
	private Logger logger=Logger.getLogger(uu.class);
	@Test
	public void test() {
		List<User>list=new ArrayList<User>();
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.createSqlsession();
			//4.调用mapper文件对数据操作,必须将mapper文件引入到mybatis-config.xml
			list=sqlSession.selectList("hxj.dao.NewFile.list");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for (User user : list) {
			logger.info(">>>>"+user.getUserName());
		}
	}
	@Test
	public void ll(){
		List<User>list=new ArrayList<User>();
		SqlSession session=null;
		try {
			session=MyBatisUtil.createSqlsession();
			list=session.getMapper(UserMapper.class).list("2");
			for (User user : list) {
				logger.info(user.getUserName()+"\t"+user.getUserPassword());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
	}
}
