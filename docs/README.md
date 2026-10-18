# VangtiChai — CSE 489 Assignment 1

**Course:** CSE 489 — Mobile Application Development  
**Assignment:** Assignment 1 — Bangladeshi Taka Change Breakdown Calculator with Custom Keypad  
**Language:** Kotlin  
**UI Framework:** Native Android XML Layouts (`ConstraintLayout`)  

---

## 1. Project Overview & Purpose
**VangtiChai** is a native Android application that accepts a monetary amount entered via a custom numeric keypad and calculates the exact minimum breakdown of Bangladeshi Taka (BDT) notes and coins required for that amount using a greedy calculation algorithm.

Supported BDT Denominations:
- **৳500**
- **৳100**
- **৳50**
- **৳20**
- **৳10**
- **৳5**
- **৳2**
- **৳1**

---

## 2. Key Features

1. **Custom Numeric Keypad:**
   - 10 Digit buttons (`0` to `9`) and 1 `CLEAR` button.
   - Built entirely with native Android UI buttons without relying on system keyboard inputs.
2. **Real-time Input & Display:**
   - Digits append to the right as pressed (`2` ➔ `23` ➔ `234`).
   - Prevents leading zeros and guards against numeric overflow.
   - Displays `Taka:` when empty/zero, or `Taka: <amount>` dynamically.
3. **Greedy Change Calculation Algorithm:**
   - Breakdown calculated from largest denomination (৳500) to smallest (৳1).
   - Generates exact note/coin counts for each denomination (`500: 1`, `100: 2`, etc.).
4. **Orientation-Responsive Layouts:**
   - **Portrait Layout (`res/layout/activity_main.xml`):** Amount at top center, breakdown list on the left, keypad on the right.
   - **Landscape Layout (`res/layout-land/activity_main.xml`):** Amount at top center, breakdown list split into 2 vertical columns on the left, 4x3 keypad grid on the right.
5. **Lifecycle-Aware State Preservation:**
   - Uses `VangtiChaiViewModel` with `SavedStateHandle` to preserve user input and breakdown calculation seamlessly across screen rotations.
6. **No Hardcoded XML Dimensions:**
   - All text sizes (`sp`), paddings, margins, and heights (`dp`) are stored in `res/values/sizes.xml` and `res/values-sw600dp/sizes.xml`.

---

## 3. How to Open, Build, and Run

### In Android Studio:
1. Open Android Studio and select **Open** ➔ Navigate to `D:\app development\Vangtichai`.
2. Allow Gradle sync to complete.
3. Select `app` from the top toolbar run configurations.
4. Select a target emulator or physical device and click **Run (`▶`)** or press **`Shift + F10`**.

### Via Terminal / Command Line:
```powershell
# Run Unit Tests
.\gradlew test

# Build Debug APK
.\gradlew assembleDebug

# Install on connected emulator or device
.\gradlew installDebug
```

---

## 4. Tested Screen Configurations
- **Pixel XL:** Portrait & Landscape
- **Nexus 10 Tablet:** Portrait & Landscape (`values-sw600dp` dimension scaling)
- **Unit Tests (`ChangeCalculatorTest`):** Verified amounts `0`, `1`, `2`, `5`, `786` (Assignment reference example), `1000`, `9999`, and `999,999,999`.

---

## 5. Documentation Directory Contents (`/docs`)
- `docs/AI_USAGE_DECLARATION.md`: Complete AI tool usage declaration and prompt history log.
- `docs/README.md`: This project summary and documentation file.
