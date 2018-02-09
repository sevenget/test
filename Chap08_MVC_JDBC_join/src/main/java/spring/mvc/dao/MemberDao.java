package spring.mvc.dao;

import java.util.List;

import spring.mvc.dto.MemberDto;

public interface MemberDao {
	public int getMemberCount();
	public int insertMember(MemberDto memberDto);
	public List<MemberDto> getMemberList(int startRow, int endRow);
	public MemberDto getDetailMember(String id);
	public int updateMember(MemberDto memberDto);
	public int deleteMember(String id);
}
