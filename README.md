# Trust Wallet Mobile Automation Framework

This repository contains the automated test suite for the Android **Trust Wallet** app. It follows the Page Object Model (POM) pattern and uses Java + TestNG + Appium.

---

## 📁 Repository Structure

```
.
├── src
│   ├── main
│   │   └── java/pages      ← Page Object classes
│   └── test
│       ├── java/tests      ← TestNG test classes
│       └── resources       ← APKs, test data, etc.
├── manual-test-cases       ← Excel/CSV of manual test cases
├── pom.xml                 ← Maven configuration
└── README.md
```

---

## 📝 Manual Test Case References

- `manual-test-cases/CreateWallet.xlsx`
    - **TC01**: Launch app & tap **Create New Wallet**
    - **TC02**: Enter 6-digit passcode twice
    - **TC03**: Deny/Allow notifications
    - **TC04**: Confirm wallet-ready screen
    - **TC05**: Buy Crypto flow
    - …and more mapped to automated tests

Please open that spreadsheet to see each step, expected results, and test data.

---

## ⚙️ Environment Setup

### 1. Java (JDK 17+)

**macOS**
```bash
brew install openjdk@17
```
Add to your `~/.zshrc` or `~/.bash_profile`:
```bash
export JAVA_HOME="$(/usr/libexec/java_home -v17)"
export PATH="$JAVA_HOME/bin:$PATH"
```

**Windows**
1. Download & install JDK 17 from Oracle or AdoptOpenJDK.
2. In **System Properties → Environment Variables**, set:
   ```
   JAVA_HOME=C:\Program Files\Java\jdk-17
   PATH=%JAVA_HOME%\bin;%PATH%
   ```

Verify:
```bash
java -version
```

---

### 2. Node.js & Appium CLI

1. Install Node.js (LTS) from https://nodejs.org
2. Install Appium globally:
   ```bash
   npm install --location=global appium
   ```
3. (Optional) Install Appium Inspector desktop app.

Verify:
```bash
npm -v
appium --version
```

---

### 3. Android Studio & SDK

1. Download Android Studio: https://developer.android.com/studio
2. Open **SDK Manager** → install:
    - Android Platform API 33+
    - Android SDK Tools
    - Android Emulator
3. Create an AVD (e.g. Pixel 6, API 33) in **Device Manager**.

---

### 4. Android Emulator

Start your emulator before running tests:

```bash
# macOS/Linux
emulator -avd Pixel_6_API_33

# or from Android Studio: Device Manager → ▶︎
```

---

## 🔧 Project Dependencies

This project uses **Maven**. Key dependencies:

- `org.testng:testng`
- `io.appium:java-client`
- `org.seleniumhq.selenium:selenium-java`
- `io.qameta.allure:allure-testng` (optional for reports)

All are defined in `pom.xml`.

---

## 🚀 Running Automated Tests

### 1) From the CLI (Maven)

```bash
# Start Appium server in a separate shell:
appium

# Run all tests:
mvn clean test

# Run a single TestNG class:
mvn test -Dtest=FullBuyFlowTest
```

### 2) Using IntelliJ IDEA

1. Open the project.
2. Let IntelliJ index & download dependencies.
3. Create a **Run Configuration** for TestNG:
    - **Suite**: `src/test/resources/testng.xml`
4. Click ▶︎ to run.

---

## 🧩 Automation Code Organization

- **BasePage.java**
    - Common `driver`, `waitForVisibility()`, `click()`, `type()`, etc.
- **Page Objects** under `src/main/java/pages/`
    - One class per screen: `HomePage`, `PasscodePage`, `NotificationPermissionPage`, `WalletReadyPage`, `BuyCryptoPage`, `MoonPaySignInPage`, etc.
- **Tests** under `src/test/java/tests/`
    - One TestNG class per flow: `CreateWalletTest`, `NotificationPermissionTest`, `FullBuyFlowTest`, etc.
- **SystemPermissionPopup.java**
    - Helper for native system dialogs (Android permission).

---

## 🗂️ File Management Best Practices

- **.gitignore** excludes:
    - `*.apk`, `/target/`, `/logs/`, IDE files
- Large APKs stored externally or via Git LFS
- Test data & manual cases in `manual-test-cases/`

---

## 📈 Reporting & CI

- Integration with Jenkins/GitHub Actions:
    - Start emulator via `sdkmanager` + `avdmanager`
    - Run `mvn clean test`
    - Publish Allure or TestNG HTML reports

---

## ❓ Troubleshooting

- **Element Not Found**: ensure emulator unlocked and correct context (native vs. webview).
- **Permission dialogs**: tests include fallbacks (`SystemPermissionPopup`).
- **WebView flows**: call `driver.getContextHandles()` and `driver.context(…)` before interacting.

---
