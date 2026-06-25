//LABORATIORIO 11 - EJERCICIO 6

package hash;

public class SessionCache {
    
    public static class Session {
        String token;
        String username;
        String role;
        long expiresAt;

        public Session(String token, String username, String role, long expiresAt) {
            this.token = token;
            this.username = username;
            this.role = role;
            this.expiresAt = expiresAt;
        }

        @Override
        public String toString() {
            return "[" + username + " (" + role + ") - Expira: " + expiresAt + "]";
        }
    }

    // Utiliza una tabla hash abierta por encadenamiento
    private java.util.LinkedList<Session>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public SessionCache(int size) {
        this.size = size;
        this.table = new java.util.LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new java.util.LinkedList<>();
        }
    }

    private int hash(String token) {
        return Math.abs(token.hashCode()) % size; // token.hashCode() según guía
    }

    // 1. Iniciar sesión / Registrar
    public void login(String token, String username, String role, long ttlMs) {
        int index = hash(token);
        long expiresAt = System.currentTimeMillis() + ttlMs;
        Session newSession = new Session(token, username, role, expiresAt);
        
        // Evitar duplicados de tokens activos
        logout(token);
        table[index].addLast(newSession);
    }

    // 2. Validar token activo y no expirado
    public Session validate(String token) {
        int index = hash(token);
        for (Session s : table[index]) {
            if (s.token.equals(token)) {
                if (System.currentTimeMillis() < s.expiresAt) {
                    return s; // Válido
                } else {
                    return null; // Expirado
                }
            }
        }
        return null;
    }

    // 3. Cierre de sesión explícito
    public void logout(String token) {
        int index = hash(token);
        table[index].removeIf(s -> s.token.equals(token));
    }

    // 4. Limpieza automática de elementos expirados
    public void cleanExpired() {
        int count = 0;
        long now = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            int prevSize = table[i].size();
            table[i].removeIf(s -> now > s.expiresAt);
            count += (prevSize - table[i].size());
        }
        System.out.println("Limpieza completada. Se eliminaron " + count + " sesiones expiradas.");
    }
}
