package dat3.car.Service;

import dat3.car.DTO.CarResponse;
import dat3.car.DTO.MemberRequest;
import dat3.car.DTO.MemberResponse;
import dat3.car.entity.Member;
import dat3.car.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberResponse> getMembers(boolean includeAllData) {

        List<Member> members = memberRepository.findAll();

        //Gammel nedern måde vi knoverterer data på
     /* List<MemberResponse> response = new ArrayList<>();

        for (Member m : members) {
            response.add(new MemberResponse(m, includeAllData));
        }*/

        //Seje moderne måde at gøre det på :sunglasses:
        List<MemberResponse> response = members.stream().map((member -> new MemberResponse(member, includeAllData))).toList();

        return response;
    }

    public MemberResponse addMember(MemberRequest body) {
        //Tjekker om brugernavnet allerede findes i databasen?
        if (memberRepository.existsById(body.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user already exists");
        }
        //Man modtager et MemberRequest objekt men det skal laves om til et Member objekt
        Member newMember = MemberRequest.getMemberEntity(body);

        newMember = memberRepository.save(newMember); //Her saver man memberen til databasen, og man gemmer id og timestamps, som databasen laver, til member instansen
        return new MemberResponse(newMember, true);
    }

    public ResponseEntity<Boolean> editMember(MemberRequest body, String username) {
        Member member = memberRepository.findById(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member with this username doesn't exist"));
        if (!body.getUsername().equals(username)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot change username");
        }
        member.setPassword(body.getPassword());
        member.setEmail(body.getEmail());
        member.setFirstName(body.getFirstName());
        member.setLastName(body.getLastName());
        member.setStreet(body.getStreet());
        member.setCity(body.getCity());
        member.setZip(body.getZip());
        memberRepository.save(member);
        return ResponseEntity.ok(true);
    }


    public MemberResponse findById(String username) {
        Member member = memberRepository.findById(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member with this username doesn't exist"));
        return new MemberResponse(member, true);
    }

    public void setRankingForUser(String username, int value) {
        Member member = getMemberByUsername(username);
        member.setRanking(value);
        memberRepository.save(member);
    }


    public void deleteMemberByUsername(String username) {
        Member member = getMemberByUsername(username);
        memberRepository.delete(member);
    }


    private Member getMemberByUsername(String username){
        return memberRepository.findById(username).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Member with this username does not exist"));
    }


    public List<MemberResponse> getMembersWithReservations() {
        return memberRepository.findAll().stream()
                .filter(member -> !member.getReservations().isEmpty())
                .map(member -> new MemberResponse(member, true))
                .collect(Collectors.toList());
    }
}
