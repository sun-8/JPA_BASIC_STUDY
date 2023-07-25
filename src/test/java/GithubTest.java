public class GithubTest {
    // 이것은 git 테스트 파일입니다.
    // feature을 하나 생성 합니다. 이름은 test01. 파일을 수정하여 commit을 합니다.
    // 또 하나의 feature을 생성하되 이름은 test01_01로 하고, feature/test01을 기준으로 feature를 생성합니다.
    // test01_01에도 수정사항을 적용하여 commit합니다.
    // 그렇다면 이런 형식일 것입니다.
    /* feature/test01
            feature/test01_01 */
    // 이때, test01을 push하여 develop에 merge시켰을 때 test01_01은 어떠한 상태가 되는지 테스트 해보겠습니다.
    
    // feature/test01_01을 생성했습니다.

    // 실험 결과 : test01 feature를 finish하여 develop에 merge 후
    //      develop push한 상태에서 test01_01 feature를 finish 하려고 했지만
    //      'Error: Please have a look at the Version Control console for more details'라는 에러메시지를 띄우며 실행되지 않았습니다.
    //      feature/test01_01 에서 다음 명령을 실행하여 develop 브랜치와 rebase를 진행했습니다.
    //      'git rebase develop'
    //      해당 명렁어로 인해 feature/test01_01 브랜치가 develop 브랜치 위로 rebase되었습니다.
    //      이후에는 필요에 따라 develop 브랜치를 push하여 원격 저장소와 동기화하면 됩니다.
    //      기존에 있던 feature는 delete해주었습니다.

    // ! 해당 실험이 여러가지 시도를 해볼 결과라서 실험결과가 정확하지 않을 수 있습니다.
}
