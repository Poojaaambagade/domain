//
//  PersistenceController.swift
//  E-Learning
//
//  Created by admin on 17/02/25.
//

import Foundation
import CoreData

struct PersistenceController {
    static let shared = PersistenceController()
    
    let container: NSPersistentContainer
    
    init(inMemory: Bool = false){
        container = NSPersistentContainer(name: "UserApp")
        if inMemory {
            container.persistentStoreDescriptions.first?.url = URL(fileURLWithPath: "/dev/null")
        }
        container.loadPersistentStores { _, error in if let error = error as NSError? {
            fatalError("Unresolved error \(error), \(error.userInfo)")
        }
            
        }
    }
    func saveContext(){
        let context = container.viewContext
        if context.hasChanges{
            try? context.save()
        }
    }
}
