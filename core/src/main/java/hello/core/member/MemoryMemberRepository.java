package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    // 아직 데이터베이스가 확정이 되지 않았기 때문에, 메모리에 HashMap을 이용해서 데이터를 넣어주는
    // MemoryMemberRepository를 만들어준다
    private static Map<Long,Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
