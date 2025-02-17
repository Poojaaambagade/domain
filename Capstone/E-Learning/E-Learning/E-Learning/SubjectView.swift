//
//  SubjectView.swift
//  E-Learning
//
//  Created by admin on 17/02/25.
//

import SwiftUI

struct SubjectView: View {
    @Environment(\.managedObjectContext) private var viewContext
    @FetchRequest(entity: Subject.entity(), sortDescriptors: []) private var subjects: FetchedResults<Subject>
    var body: some View {
        NavigationView{
            List(subjects, id: \.self){
                subject in NavigationLink(destination:MaterialView(subject: subject)){
                    Text(subject.name ?? "UnknownSubject")
                }
            }
            .navigationTitle("Subjects")
            .toolbar {
                Button("Add Data"){
                    addSampleData()
                }
            }
        }
        
    }
    private func addSampleData(){
        let subjects = Subject(context: viewContext)
        subjects.name = "Java"
        let material = Material(context: viewContext)
        material.title = "Core Java"
        material.url = "htpps://example.com/Java"
        material.subject = subjects
        let question = Question(context: viewContext)
        question.text = "Whose invented Java"
        question.options = ["Games Gosling", "Sun Micro", "Guido van", "Rossum"] as NSObject
        question.correctanswer = "Games Gosling"
        question.subject = subjects
        
        let question2 = Question(context: viewContext)
        question2.text = "What Is Extension for java"
        question2.options = [".js", ".txt", ".class", ".java"] as NSObject
        question2.correctanswer = ".java"
        question2.subject = subjects
        do{
            try viewContext.save()
        } catch {
            print("Error saving data: \(error.localizedDescription)")
        }
    }
}

struct SubjectView_Previews: PreviewProvider {
    static var previews: some View {
        SubjectView()
    }
}
