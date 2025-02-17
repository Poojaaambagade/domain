//
//  E_LearningApp.swift
//  E-Learning
//
//  Created by admin on 17/02/25.
//

import SwiftUI

@main
struct E_LearningApp: App {
    
    let persistentController = PersistenceController.shared
    
    var body: some Scene {
        WindowGroup {
            LoginView().environment(\.managedObjectContext, persistentController.container.viewContext)
            
            ContentView()
        }
    }
}
