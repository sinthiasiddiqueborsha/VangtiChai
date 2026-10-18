# AI Tool Usage & Prompt History

**Course:** CSE 489 — Mobile Application Development  
**Assignment:** Assignment 1 — VangtiChai  
**Application Name:** VangtiChai  
**AI Assistant:** Gemini AI Assistant (Android Studio Plugin)  

---

## Declaration Statement

I hereby declare that **Gemini AI Assistant** was used as a pair-programming partner and development assistant during CSE 489 Assignment 1: VangtiChai. All prompt interactions, technical discussions, and code assistance have been transparently documented below in accordance with course guidelines.

---

## Session 1: Initial Project Implementation

**Prompt:**

I am developing Assignment 1, VangtiChai, for my CSE 489 — Mobile Application Development course. Please help me implement the complete Android application in Kotlin using Android Studio, following the assignment specification and reference screenshots.

Please ensure that the implementation includes the following requirements:

1. **Project Setup:** Configure the Gradle build files, Android manifest, required dependencies, and project structure correctly.
2. **Change Calculation Algorithm:** Implement a greedy change-calculation algorithm using the Bangladeshi Taka denominations of ৳500, ৳100, ৳50, ৳20, ৳10, ৳5, ৳2, and ৳1.
3. **User Interface:** Create the portrait and landscape XML layouts with a numeric keypad, amount display, change breakdown, and CLEAR button, following the assignment's reference screenshots.
4. **Orientation Handling:** Preserve the entered amount and calculation state when the device rotates between portrait and landscape orientations.
5. **Resource Management:** Externalize strings, colors, dimensions, and other appropriate UI resources instead of hardcoding values in layout files.
6. **Device Compatibility:** Consider the specified Pixel XL and Nexus 10 screen configurations and ensure the layouts adapt appropriately.
7. **Unit Testing:** Write unit tests for the change-calculation algorithm, including the assignment's reference example of ৳786.
8. **Documentation:** Create a README file containing the project overview and relevant instructions.

Organize the code into appropriate Kotlin classes and Android resource files. Follow good programming practices, maintain readability, and verify the implementation through available build and test commands. Clearly report any errors or requirements that remain unresolved.

---

## Session 2: Application Execution Instructions

**Prompt:**

Please explain how to run the VangtiChai Android application in Android Studio. Provide step-by-step instructions for selecting the correct run configuration, choosing an emulator or connected device, and launching the application. Also explain the relevant Gradle commands for building, installing, and testing the project.

---

## Session 3: Run Configuration Setup

**Prompt:**

The application run-configuration dropdown in Android Studio is not showing the expected app configuration. Please guide me through selecting the correct application module and configuring the run settings. Explain how to check whether the project has been imported correctly and how to synchronize the project with Gradle if the app configuration is missing.

---

## Session 4: Troubleshooting the Missing Application Module

**Prompt:**

Android Studio displays “Add Configuration...” and the Run button is disabled. The VangtiChai application is also missing from the available module list.

Please help me diagnose and resolve this issue step by step. Check whether the correct project root directory is open, whether the Gradle configuration files are present, and whether Android Studio has successfully recognized the Android application module. Recommend appropriate troubleshooting steps, including Gradle synchronization and project re-importing where necessary. Avoid modifying project configuration files unless there is a clear technical reason.

---

## Session 5: Aligning the UI with the Assignment Reference Screenshots

**Prompt:**

I have compared the current VangtiChai application interface with the reference screenshots provided in the assignment specification. Please help me identify and correct the visual differences so that the application follows the reference design as closely as possible.

Please pay particular attention to the following:

1. The action bar color and application title.
2. The position and alignment of the entered amount.
3. The change-denomination breakdown and corresponding quantities.
4. The size, spacing, alignment, and appearance of the numeric keypad buttons.
5. The placement and dimensions of the CLEAR button.
6. The portrait layout and the landscape layout, including the arrangement of denomination columns and keypad buttons.
7. Consistent use of colors, dimensions, strings, and other Android resources.

Update the relevant XML layouts, resource files, and Kotlin code only where necessary. Preserve the existing calculation logic and state-management behavior. After making the changes, verify that both orientations remain functional and run the available unit tests and build checks.

---

## Session 6: AI Usage Declaration and Documentation

**Prompt:**

My assignment requires all project documentation and the AI usage declaration to be stored in the `/docs` directory of the Git repository.

Please help me prepare professional English documentation for the VangtiChai project. Include an AI usage declaration that transparently explains the role of Gemini AI Assistant in the development process and a chronological summary of the relevant prompts and interactions.

Organize the documentation clearly, covering project implementation, application execution, run-configuration troubleshooting, UI refinement, and testing. Include the relevant technical details without claiming that an action, test, or verification was completed unless it was actually performed.

Create or update the appropriate documentation files, such as `docs/AI_USAGE_DECLARATION.md` and `docs/README.md`, while preserving the existing project structure and source code. Ensure that the documentation is accurate, readable, and suitable for academic submission.

---

> **Declaration Note:** The prompts above are polished reconstructions of the documented AI interactions, organized to describe the assistance used during development. They are not necessarily verbatim copies of the original messages.
