package dataannotation.screening.test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecretMessageDecoder {

	public static void printSecretMessage(String docUrl) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(docUrl)).build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String body = response.body();

			// Strip HTML tags so we only extract the text content from the table
			String plainText = body.replaceAll("<[^>]*>", " ");
			String[] tokens = plainText.split("\\s+");

			List<Pixel> pixels = new ArrayList<>();
			int maxX = 0;
			int maxY = 0;

			// Collect all valid tokens (looking for number, character, number pattern)
			List<String> validTokens = new ArrayList<>();
			for (String token : tokens) {
				if (!token.isBlank()) {
					validTokens.add(token.trim());
				}
			}

			// Parse tokens in chunks (x, character, y) or skip non-data headers
			for (int i = 0; i < validTokens.size() - 2; i++) {
				try {
					int x = Integer.parseInt(validTokens.get(i));
					String chStr = validTokens.get(i + 1);
					int y = Integer.parseInt(validTokens.get(i + 2));

					if (chStr.length() == 1) {
						char ch = chStr.charAt(0);
						pixels.add(new Pixel(ch, x, y));
						maxX = Math.max(maxX, x);
						maxY = Math.max(maxY, y);
						i += 2; // Skip past character and y
					}
				} catch (NumberFormatException ignored) {
					// Not a coordinate triplet yet, continue searching
				}
			}

			// Initialize the grid with spaces
			char[][] grid = new char[maxY + 1][maxX + 1];
			for (char[] row : grid) {
				Arrays.fill(row, ' ');
			}

			// Place characters at their respective (x, y) coordinates
			for (Pixel p : pixels) {
				if (p.y <= maxY && p.x <= maxX) {
					grid[p.y][p.x] = p.ch;
				}
			}

			// Print the final decoded grid
			for (int y = 0; y <= maxY; y++) {
				System.out.println(new String(grid[y]));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static class Pixel {
		char ch;
		int x;
		int y;

		Pixel(char ch, int x, int y) {
			this.ch = ch;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		String url = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub";
		printSecretMessage(url);
	}

}
