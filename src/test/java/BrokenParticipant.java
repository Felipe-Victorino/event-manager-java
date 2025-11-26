import model.Participant;
import service.ParticipantService;

public class BrokenParticipant {
	static void main() {
		new ParticipantService().createParticipant("Seu João", "00000000001");
	}
}