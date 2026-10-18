================================================================================
                                  VangtiChai
                       CSE 489: Assignment 1 Project
================================================================================

1. PROJECT NAME:
   VangtiChai

2. COURSE:
   CSE 489 — Mobile Application Development

3. ASSIGNMENT:
   Assignment 1 — Bangladeshi Taka Change Breakdown Calculator with Custom Keypad

4. APPLICATION PURPOSE:
   VangtiChai is a native Android application designed to calculate the minimal
   number of Bangladeshi Taka (BDT) notes and coins needed for any specified amount
   using a standard greedy change calculation algorithm.

5. MAIN FEATURES:
   - Custom Numeric Keypad: Built using native Android XML buttons (0-9 and Clear).
   - Real-Time Amount Display: Updates dynamically as digits are pressed.
   - Intelligent Input Handling: Prevents invalid leading zeros and guards against overflow.
   - Comprehensive Change Breakdown Table: Displays all 8 Bangladeshi Taka
     denominations (৳500, ৳100, ৳50, ৳20, ৳10, ৳5, ৳2, ৳1) along with respective
     counts, subtotals, and overall totals.
   - Orientation-Responsive Layouts:
     * Portrait layout (`res/layout/activity_main.xml`): Amount display at top,
       Breakdown table on left, Numeric keypad on right.
     * Landscape layout (`res/layout-land/activity_main.xml`): Optimized widescreen
       arrangement keeping Amount & Table on left, Keypad on right.
   - Seamless State Preservation: Retains user input and calculation breakdown across
     device rotations (Portrait <-> Landscape) using ViewModel + SavedStateHandle.
   - Multi-Device & Tablet Support: Scaled layout dimensions (`res/values/sizes.xml` and
     `res/values-sw600dp/sizes.xml`) supporting phones (e.g. Pixel XL) and tablets
     (e.g. Nexus 10).

6. PROGRAMMING LANGUAGE & MAJOR ANDROID TECHNOLOGIES:
   - Programming Language: Kotlin
   - UI Framework: Native Android XML Layouts with ConstraintLayout
   - Architecture: Android Jetpack ViewModel, LiveData, SavedStateHandle
   - View Binding: Enabled for clean view interactions without findViewById overhead
   - Material Design 3 Components (MaterialCardView, etc.)
   - Resource Externalization: All dimensions defined in sizes.xml; strings in strings.xml

7. INSTRUCTIONS TO OPEN, BUILD, AND RUN THE APP:
   a. Open Android Studio and select "Open" -> Navigate to project folder:
      `D:\app development\Vangtichai`
   b. Allow Gradle to sync dependencies.
   c. Build command via terminal:
      `.\gradlew assembleDebug`
   d. Run Unit Tests:
      `.\gradlew test`
   e. To run on an emulator or connected device:
      `.\gradlew installDebug` or press Shift+F10 in Android Studio.

8. HOW THE CHANGE-CALCULATION ALGORITHM WORKS:
   The application uses a Greedy Change Breakdown Algorithm:
   - Denominations evaluated in descending order: [500, 100, 50, 20, 10, 5, 2, 1].
   - For each denomination `d`:
     * Count = `remainingAmount / d`
     * Subtotal = `Count * d`
     * `remainingAmount` = `remainingAmount % d`
   - Guarantees minimum total note/coin count while ensuring the sum of all subtotals
     always equals the original entered amount.

9. HOW THE APP PRESERVES STATE WHEN ROTATING:
   - State is managed inside `VangtiChaiViewModel` which uses `SavedStateHandle`.
   - The amount string is saved under key `"key_amount_string"` in `SavedStateHandle`.
   - On screen rotation, Android recreates the Activity layout (`activity_main.xml` or
     `layout-land/activity_main.xml`), but `VangtiChaiViewModel` survives the rotation.
   - LiveData automatically re-emits the current amount and change breakdown to the
     newly inflated UI views without losing any data.

10. REQUIRED DEVICE / ORIENTATION CONFIGURATIONS:
    - Pixel XL (411 x 731 dp) — Portrait & Landscape
    - Nexus 10 Tablet (800 x 1280 dp) — Portrait & Landscape

11. ADDITIONAL DEVICE CONFIGURATIONS TESTED:
    - Automated Kotlin Unit Test cases (`ChangeCalculatorTest`) verifying amounts:
      0, 1, 2, 5, 786 (assignment PDF reference example), 1000, 9999, and 999,999,999.
    - Verified Gradle Debug Build & Compilation (`.\gradlew assembleDebug`).

12. LIMITATIONS & ENVIRONMENT TESTING NOTES:
    - No physical or virtual emulator device was currently running during local build.
      However, the project was successfully compiled (`assembleDebug`) and all unit
      tests (`test`) executed with 100% pass rate.
================================================================================
