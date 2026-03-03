namespace HashingAlgorithm
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] passwords = { "Haus", "Maus", "Raus", "Laus", "aLus" };

            foreach (var pw in passwords)
            {
                string hash = HashingAlgorithm(pw);
                Console.WriteLine($"Password: {pw} -> Hash: {hash}");
            }
        }

        static string? HashingAlgorithm(string input)
        {
            if (input.Length != 4)
            {
                return null;
            }

            // Primzahlen pro Position sorgen dafür, dass die Zeichenposition
            // den Hash beeinflusst ("Laus" != "aLus")
            int[] positionPrimes = { 7, 31, 127, 211 };

            long hash = 0;

            for (int i = 0; i < 4; i++)
            {
                int charValue = input[i];
                // Positionsabhängige Berechnung mit Primzahlen und Potenzierung
                hash += charValue * positionPrimes[i] * (i + 1);
                hash *= 31;
                hash += charValue * charValue + i * 997;
            }

            // Sicherstellen, dass der Wert positiv ist
            hash = Math.Abs(hash);

            // Auf 8 Stellen bringen (10000000 bis 99999999)
            hash = hash % 90000000 + 10000000;

            return hash.ToString("D8");
        }
    }
}