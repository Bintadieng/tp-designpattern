// Interface Strategy
public interface EncryptionStrategy {
    String encrypt(String message);

    String decrypt(String encrypted);
}

// Stratégie XOR
public class XorEncryptionStrategy implements EncryptionStrategy {
    private static final int MASK = 103;

    @Override
    public String encrypt(String message) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ MASK);
        }
        return new String(chars);
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted); // XOR est symétrique
    }
}

// Stratégie Décalage
public class ShiftEncryptionStrategy implements EncryptionStrategy {
@Override
    public String encrypt(String message) {
        char[] chars = message.toCharArray();
        for