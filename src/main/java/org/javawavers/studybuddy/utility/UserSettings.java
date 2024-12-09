package org.javawavers.studybuddy.utility;

public class UserSettings {
    // Υπεύθυνη για τη διαχείριση των ρυθμίσεων χρήστη, όπως email, ειδοποιήσεις, προφίλ κ.α.
        private String password;
        private String email;
        private boolean emailNotifications;
        private boolean pushNotifications;
        // Προτιμήσεις θέματος (π.χ, dark mode ή light mode)
        private String themePreference;

        public UserSettings(String password, String email) {
            this.password = password;
            this.email = email;
            this.emailNotifications = true; // Προεπιλογή ενεργών ειδοποιήσεων
            this.pushNotifications = true; // Προεπιλογή ενεργών ειδοποιήσεων
            this.themePreference = "Light"; // Προεπιλογή θέματος
        }

        // Μέθοδος για αλλαγή κωδικού πρόσβασης
        public void updatePassword(String newPassword) {
            this.password = newPassword;
            System.out.println("Ο κωδικός πρόσβασης ενημερώθηκε επιτυχώς.");
        }

        // Μέθοδος για αλλαγή email
        public void updateEmail(String newEmail) {
            this.email = newEmail;
            System.out.println("Το email ενημερώθηκε σε: " + newEmail);
        }

        // Μέθοδος για αλλαγή προτιμήσεων ειδοποιήσεων
        public void setNotificationPreferences(boolean enableEmail, boolean enablePush) {
            this.emailNotifications = enableEmail;
            this.pushNotifications = enablePush;
            System.out.println("Ρυθμίσεις ειδοποιήσεων ενημερώθηκαν.");
        }

        // Μέθοδος για αλλαγή θέματος
        public void chooseTheme(String theme) {
            this.themePreference = theme;
            System.out.println("Το θέμα άλλαξε σε: " + theme);
        }
    }


