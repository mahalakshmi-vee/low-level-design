## **Design Stack Overflow**

### **Requirements:**
1. Users can post questions, answer questions, and comments on questions and answers.
2. Users can vote on questions and answers. Additionally, they can upvote comments, but only if they have atleast 50 reputation points.
3. Questions should have tags associated with them.
4. Users can search questions based on tags, keywords, or user profiles.
5. The system should assign reputation score to users based on their activity and the quality of their contributions.
6. Users can accept only one answer per question.
7. The system should handle concurrent access and ensure data consistency.

### **Reputation System:**

#### **How Users Gain Reputation:**
A user's question is upvoted: +5
A user's answer is upvoted: +10
A user's answer is accepted by the question author: +15
A user accepts someone's answers to their questions: +2

#### **How Users Lose Repuations:**
A user's question is downvoted: -2
A user's answer is downvoted: -2
