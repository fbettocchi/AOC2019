package AoC2019;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DAY2 {

	public static void main(String[] args) throws Exception {

		for (int noun = 0; noun < 100; ++noun) {
			for (int verb = 0; verb < 100; ++verb) {
				List<Integer> program = Arrays.asList(1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 1, 9, 19, 1,
						19, 5, 23, 2, 6, 23, 27, 1, 6, 27, 31, 2, 31, 9, 35, 1, 35, 6, 39, 1, 10, 39, 43, 2, 9, 43, 47,
						1, 5, 47, 51, 2, 51, 6, 55, 1, 5, 55, 59, 2, 13, 59, 63, 1, 63, 5, 67, 2, 67, 13, 71, 1, 71, 9,
						75, 1, 75, 6, 79, 2, 79, 6, 83, 1, 83, 5, 87, 2, 87, 9, 91, 2, 9, 91, 95, 1, 5, 95, 99, 2, 99,
						13, 103, 1, 103, 5, 107, 1, 2, 107, 111, 1, 111, 5, 0, 99, 2, 14, 0, 0);
				program.set(1, noun);
				program.set(2, verb);
				try {
					if (readProgram(program).get(0) == 19690720) {
						System.out.println("Resultat: " + (100 * noun + verb));
						System.exit(0);
					}
				} catch (Exception e) {
				}
			}
		}

	}

	public static List<Integer> readProgram(List<Integer> program) throws Exception {

		Iterator<Integer> iterator = program.iterator();
		int opCode;
		while (iterator.hasNext()) {
			opCode = iterator.next();
			if (opCode == 1) {
				int arg1 = program.get(iterator.next());
				int arg2 = program.get(iterator.next());
				program.set(iterator.next(), arg1 + arg2);
			} else if (opCode == 2) {
				int arg1 = program.get(iterator.next());
				int arg2 = program.get(iterator.next());
				program.set(iterator.next(), arg1 * arg2);
			} else if (opCode == 99) {
				return program;
			} else {
				throw new Exception("erreur opcode : "+opCode);
			}
		}
		return program;
	}
}
