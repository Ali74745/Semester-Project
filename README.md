# Hospital Management System

A Java GUI application to manage patients, doctors, and nurses with role-based access (admin/doctor/nurse).  
Uses serialized files for storage and Swing for the interface.

## Features
- Admin: add/view/remove staff & patients
- Doctor: view patient vitals & history, see schedule
- Nurse: update patient vitals/history, see schedule
- Persistent storage using `.ser` files

## Run
1. Open in any Java IDE
2. Run `Management.java`
3. Login:
   - Admin: `admin` / `123`
   - Doctor/Nurse: use respective ID

## Structure
- Package: `HOSPITAL`
- Files: `Management.java`, `Patient.java`, `Doctor.java`, `Nurse.java`, `MedicalHistory.java`, `Info.java`, `Shifts.java`
- Images: `bg.jpg`, `corridor.jpg`
