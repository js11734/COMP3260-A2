public class Main {
    private static final int[] InsPermutation = { //Inisital Permuation Table (IP)
        58, 50, 42, 34, 26, 18, 10, 2,
        60, 52, 44, 36, 28, 20, 12, 4,        
        62, 54, 46, 38, 30, 22, 14, 6,        
        64, 56, 48, 40, 32, 24, 16, 8,        
        57, 49, 41, 33, 25, 17, 9, 1,        
        59, 51, 43, 35, 27, 19, 11, 3,        
        61, 53, 45, 37, 29, 21, 13, 5,        
        63, 55, 47, 39, 31, 23, 15, 7 
    };
    private static final int[] ExpTable = { //Expansion Table (E)
        32, 1, 2, 3, 4, 5,
        4, 5, 6, 7, 8, 9,
        8, 9, 10, 11, 12, 13,
        12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21,
        20, 21, 22, 23, 24, 25,
        24, 25, 26, 27, 28, 29,
        28, 29, 30, 31, 32, 1
    };
    private static final int[] PermutationFunction = { //PermutationFunction Table (P)
        16, 7, 20, 21, 29, 12, 28, 17,
        1, 15, 23, 26, 5, 18, 31, 10,
        2, 8, 24, 14, 32, 27, 3, 9,
        19, 13, 30, 6, 22, 11, 4, 25
    };
    private static final int[] InvPermutation = { //Inverse Permutation Table (IP-1)
        40, 8, 48, 16, 56, 24, 64, 32,
        39, 7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30,
        37, 5, 45, 13, 53, 21, 61, 29,
        36, 4, 44, 12, 52, 20, 60, 28,
        35, 3, 43, 11, 51, 19, 59, 27,
        34, 2, 42, 10, 50, 18, 58, 26,
        33, 1, 41, 9, 49, 17, 57, 25
    };
    private static final int[][][] SBoxes = { //Subititution Boxes
        {//S1
            { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
            { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
            { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
            { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 }
        },
        {//S2
            {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
            {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
            {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
            {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
        },
        {//S3
            {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
            {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
            {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
            {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
        },
        {//S4
            {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
            {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
            {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
            {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
        },
        {//S5
            {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
            {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
            {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
            {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
        },
        {//S6
            {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
            {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
            {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
            {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
        },
        {//S7
            {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
            {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
            {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
            {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
        },
        {//S8
            {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
            {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
            {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
            {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
        }
    };
    private static final int[] PemutationChoice1C = { //Pemutation Choice Table (PC-1) for C
        57, 49, 41, 33, 25, 17, 9,
        1, 58, 50, 42, 34, 26, 18,
        10, 2, 59, 51, 43, 35, 27,
        19, 11, 3, 60, 52, 44, 36,
    };
    private static final int[] PemutationChoice1D = { //Pemutation Choice Table (PC-1) for D
        63, 55, 47, 39, 31, 23, 15,
        7, 62, 54, 46, 38, 30, 22,
        14, 6, 61, 53, 45, 37, 29,
        21, 13, 5, 28, 20, 12, 4
    };
    private static final int[] PemutationChoice2 = { //Pemutation Choice Table (PC-2)
        14, 17, 11, 24, 1, 5, 3, 28,
        15, 6, 21, 10, 23, 19, 12, 4,
        26, 8, 16, 7, 27, 20, 13, 2,
        41, 52, 31, 37, 47, 55, 30, 40,
        51, 45, 33, 48, 44, 49, 39, 56,
        34, 53, 46, 42, 50, 36, 29, 32
    };    
    private static final int[] LeftShifts = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 }; //Left Shifts for key parts

       public static int hammingDistance(long a, long b) { //performs a bitwise XOR between a and b, shows how much the output changes between rounds when 1 input bit is flipped
        long x =a^b; //XOR to identify differing bits
        int setBits =0;
        while(x>0) //Count the number of 1s in the result
        {
            setBits += x & 1; //Check if least significant bit is 1
            x >>=1; //Shift right by 1
        }
        return setBits; //Returns numbering of differing bits
    }
    
    
    private static long permute(long input, int[] permutationTable) { //Applies Permutation tables for various functions
        long output = 0;
        for (int i = 0; i < permutationTable.length; i++) { // Runs through selected table
            output |= (input >> (64 - permutationTable[i])) & 0x01;
            if (i < permutationTable.length - 1) {
                output <<= 1;
            }
        }
        return output;
        }
        private static int permuteFunction(int input, int[] permutationTable) { //Applies Permutation tables for Permutation Function
            long output = 0; //Expands into 64-bit for permutation
            for (int i = 0; i < permutationTable.length; i++) { 
                output |= (input >> (64 - permutationTable[i])) & 0x01;
                if (i < permutationTable.length - 1) {
                    output <<= 1;
                }
            }
            long convert = output & 0xFFFFFFFFL;
            return (int) convert; //Converts back into 32-bit data type
            }
    public static long[] KeyGenerate(long key) { //Splits key for Rounds FUnction
        long[] roundKeys = new long[16]; //Placeholder variable for the subkeys
        int rawC = (int) (key >> 28) & 268435455; //Splits key into 28-bit halves
        int rawD = (int) key & 268435455;
        int splitC = (int) permute(rawC, PemutationChoice1C); //Permute half C with Choice1-C table
        int splitD = (int) permute(rawD, PemutationChoice1D); //Permute half D with Choice1-D table
        for (int i = 0; i < 16; i++) { //Genertate round keys for 16 rounds
            int roundC = ((splitC << LeftShifts[i]) | (splitC >> (28-LeftShifts[i]))) & 268435455;
            int roundD = ((splitD << LeftShifts[i]) | (splitD >> (28-LeftShifts[i]))) & 268435455;
            long mergedCD = ((long) roundC << 28) | roundD ; //Merges generated round keys
            roundKeys[i] = permute(mergedCD, PemutationChoice2); //Permute round keys with Choice 2 table
        }
        return roundKeys;
    }
    public static int sBoxSubstitution(int input) { //Implements SBox subistution
        int output = 0;
        for (int i = 0; i < 8; i++) {
            int substitute = (input >> (42 - 6 * i)) & 0x3F;
            int row = ((substitute & 0x20) >> 4) | (substitute & 1); //Generates row value from first & last bit
            int col = (substitute >> 1) & 0x0F; //Generates column value from middle bits
            output |= SBoxes[i][row][col];
            if (i < 7){
                output <<=4;
            }
        }
        return output;
    }

       public static long[] des0Rounds(long data, long[] keys) {
        long[] roundStates = new long[17]; //Stores at each round 
        long left = (data >> 32) & 0xFFFFFFFFL;
        long right = data & 0xFFFFFFFFL; //Splits data into left and right blocks
        roundStates[0] = (left << 32) | right; //Stores intial state

        //Performs 16 rounds of DES
        for (int i = 1; i <= 16; i++) {
            //Expands right using expansion table
            long expanded = permute(right, ExpTable);
            //XOR with the i-th round key
            long xored = expanded ^ keys[i - 1];
            //Apply s-box substituation
            int sboxed = sBoxSubstitution((int)xored);
            //Apply permutation function to S-box
            int permuted = permuteFunction(sboxed, PermutationFunction);
            //New right is left with XOR applied, new left becomes previous right 
            long newRight = left ^ permuted;
            left = right;
            right = newRight;
            roundStates[i] = (left << 32) | right;
        }
        return roundStates;
    }

     public static long[] des1Rounds(long data) {
        long[] roundStates = new long[17]; //Store at each round 
        long left = (data >> 32) & 0xFFFFFFFFL;
        long right = data & 0xFFFFFFFFL; //Splits data into left and right 
        roundStates[0] = (left << 32) | right;
        //Performs 16 rounds of DES 
        for (int i = 1; i <= 16; i++) {
            //Expands right using expansion table
            long expanded = permute(right, ExpTable);
            //Apply s-box substituation into expanded table
            int sboxed = sBoxSubstitution((int)expanded);
            //Apply permutation to S-box
            int permuted = permuteFunction(sboxed, PermutationFunction);
            //New Right is left with XOR applied. New left becomes previous right 
            long newRight = left ^ permuted;
            left = right;
            right = newRight;
            //Combine left and right
            roundStates[i] = (left << 32) | right;
        }
        return roundStates;
    }
  
  //inverse permutation applied to the XOR result before substituation 
    public static long[] des2Rounds(long data, long[] keys) {
        long[] roundStates = new long[17];
        long left = (data >> 32) & 0xFFFFFFFFL;
        long right = data & 0xFFFFFFFFL;
        roundStates[0] = (left << 32) | right;
        for (int i = 1; i <= 16; i++) {
            long expanded = permute(right, ExpTable);
            long xored = expanded ^ keys[i - 1];
            long invPerm = permute(xored, InvPermutation);
            int permuted = permuteFunction((int)invPerm, PermutationFunction);
            long newRight = left ^ permuted;
            left = right;
            right = newRight;
            roundStates[i] = (left << 32) | right;
        }
        return roundStates;
    }
    //Skips final permutation function and uses raw S-box
   public static long[] des3Rounds(long data, long[] keys) {
        long[] roundStates = new long[17];
        long left = (data >> 32) & 0xFFFFFFFFL;
        long right = data & 0xFFFFFFFFL;
        roundStates[0] = (left << 32) | right;
        for (int i = 1; i <= 16; i++) {
            long expanded = permute(right, ExpTable);
            long xored = expanded ^ keys[i - 1];
            int sboxed = sBoxSubstitution((int)xored);
            long newRight = left ^ sboxed;
            left = right;
            right = newRight;
            roundStates[i] = (left << 32) | right;
        }
        return roundStates;
    }
   //Compares hamming distance of two arrays at each round
    public static int[] compareRounds(long[] a, long[] b) {
    int[] diffs = new int[a.length]; //Array to store hamming distance
    for (int i = 0; i < a.length; i++) {
        diffs[i] = hammingDistance(a[i], b[i]); //Compute hamming distances between corresponding states
    }
    return diffs;
    }

     public static String longToBinaryString64(long value) {
        return String.format("%64s", Long.toBinaryString(value)).replace(' ', '0');
    }
public static void main(String[] args) {
    FileReader reader = new FileReader(); 
    reader.readInputs(); //Prompts user to enter a file name to read values from
    //Assigns variables based on data taken from txt file 
    long p = Long.parseLong(reader.getPlainText(), 2);
    long pDash = Long.parseLong(reader.getPlainTextDash(), 2);
    long k = Long.parseLong(reader.getKey(), 2);
    long kDash = Long.parseLong(reader.getKeyDash(), 2);

    long pPerm = permute(p, InsPermutation);
    long pDashPerm = permute(pDash, InsPermutation);

    long[] keysK = KeyGenerate(k);
    long[] keysKDash = KeyGenerate(kDash);

    long[][] roundsP = {
        des0Rounds(pPerm, keysK),
        des1Rounds(pPerm),
        des2Rounds(pPerm, keysK),
        des3Rounds(pPerm, keysK)
    };

    long[][] roundsPDash = {
        des0Rounds(pDashPerm, keysK),
        des1Rounds(pDashPerm),
        des2Rounds(pDashPerm, keysK),
        des3Rounds(pDashPerm, keysK)
    };

    long[][] roundsKDash = {
        des0Rounds(pPerm, keysKDash),
        des1Rounds(pPerm),
        des2Rounds(pPerm, keysKDash),
        des3Rounds(pPerm, keysKDash)
    };

    int[][] diffPvsPDash = new int[17][4];
    int[][] diffPvsKDash = new int[17][4];

    for (int round = 0; round <= 16; round++) {
        for (int i = 0; i < 4; i++) {
            diffPvsPDash[round][i] = hammingDistance(roundsP[i][round], roundsPDash[i][round]);
            diffPvsKDash[round][i] = hammingDistance(roundsP[i][round], roundsKDash[i][round]);
        }
    }

    String c1 = longToBinaryString64(roundsP[0][16]);
    String c1Dash = longToBinaryString64(roundsPDash[0][16]);
    String c2 = longToBinaryString64(roundsKDash[0][16]);

    double elapsedSeconds = 0.0; // NEEDS TO BE IMPLEMENTED 
    //Generates output 
    OutputWriter.writeOutput(
        reader.getPlainText(),
        reader.getPlainTextDash(),
        reader.getKey(),
        reader.getKeyDash(),
        c1,
        c2,
        diffPvsPDash,
        diffPvsKDash,
        elapsedSeconds
    );
}
}
 



