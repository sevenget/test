package spring.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.mvc.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MemberDto> getMemberList(int startRow, int endRow) {

		String sql = "select * from (select a.*, rownum rnum from (select * from spring_member order by reg_date desc) a) where rnum >=? and rnum <=?";

		List<MemberDto> list = jdbcTemplate.query(sql, new Object[] { startRow, endRow }, new RowMapper<MemberDto>() {
			// 물음표가 여러개있을때 object[] 형식으로 선언해서 한꺼번에 다 넣어줘도 됨
			@Override
			public MemberDto mapRow(ResultSet arg0, int arg1) throws SQLException {
				MemberDto member = new MemberDto();

				member.setId(arg0.getString("id"));
				member.setPasswd(arg0.getString("passwd"));
				member.setName(arg0.getString("name"));
				member.setReg_date(arg0.getDate("reg_date"));

				return member;
			}
		});

		return list;
	}

	@Override
	public int getMemberCount() {
		String sql = "select count(*) from spring_member";
		return jdbcTemplate.update(sql);
	}

	@Override
	public int insertMember(MemberDto memberDto) {
		String sql = "insert into spring_member values(?, ?, ?, sysdate)";
		return jdbcTemplate.update(sql, new Object[]{memberDto.getId(), memberDto.getPasswd(), memberDto.getName()});
	}

	@Override
	public MemberDto getDetailMember(String id) {
		String sql = "select * from spring_member where id = ?";
		
		MemberDto member = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<MemberDto>(){

			@Override
			public MemberDto mapRow(ResultSet arg0, int arg1) throws SQLException {

				MemberDto member = new MemberDto();
				
				member.setId(arg0.getString("id"));
				member.setPasswd(arg0.getString("passwd"));
				member.setName(arg0.getString("name"));
				member.setReg_date(arg0.getDate("reg_date"));
				
				
				return member;
			}
		});
		
		return member;
	}

	@Override
	public int updateMember(MemberDto memberDto) {
		String sql="update spring_member set passwd=?, name=? where id=?";
		return jdbcTemplate.update(sql, new Object[]{memberDto.getPasswd(), memberDto.getName(), memberDto.getId()});
	}

	@Override
	public int deleteMember(String id) {
		String sql="delete from spring_member where id=?";
		return jdbcTemplate.update(sql, new Object[]{id});
	}

}
